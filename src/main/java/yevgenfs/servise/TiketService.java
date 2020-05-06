package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.TiketRepository;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.TiketEntity;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class TiketService {
    @Autowired
    TiketRepository tiketRepository;



    public TiketEntity getTiket(Integer tiketId) throws NoSuchBookException {
        TiketEntity tiket = tiketRepository.findById(tiketId).get();//2.0.0.M7
        if (tiket == null) throw new NoSuchBookException();
        return tiket;
    }

    public List<TiketEntity> getAllTikets() {
        return tiketRepository.findAll();
    }

    @Transactional
    public void createTiket(TiketEntity tiketId) {
        tiketRepository.save(tiketId);
    }

    @Transactional
    public void updateTiket(TiketEntity uTiket, Integer tiketId) throws NoSuchBookException {

        TiketEntity tiket= tiketRepository.findById(tiketId).get();//2.0.0.M7
        if (tiket == null) throw new NoSuchBookException();
        //update
        tiket.setBusIdBus(uTiket.getBusIdBus());
        tiket.setExtraLugage(uTiket.getExtraLugage());
        tiket.setPrice(uTiket.getPrice());
        tiket.setTicetForChildren(uTiket.getTicetForChildren());
        tiket.setTicetForMan(uTiket.getTicetForMan());
        tiket.setTicetsForDisablePeople(uTiket.getTicetsForDisablePeople());
        tiket.setUserIduser(uTiket.getUserIduser());

    }

    @Transactional
    public void deleteTiket(Integer tiketId) throws NoSuchBookException {
        TiketEntity tiket= tiketRepository.findById(tiketId).get();//2.0.0.M7

        if (tiket == null) throw new NoSuchBookException();
        tiketRepository.delete(tiket);
    }
}

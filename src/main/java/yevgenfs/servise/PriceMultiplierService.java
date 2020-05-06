package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.PriceMultiplierRepository;

import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.PriceMultiplierEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PriceMultiplierService {

    @Autowired
    PriceMultiplierRepository priceMultiplierRepository ;



    public PriceMultiplierEntity getPriceMultiplier(String priceMultiplierId) throws NoSuchBookException {
        PriceMultiplierEntity priceMultiplier = priceMultiplierRepository.findById(priceMultiplierId).get();//2.0.0.M7
        if (priceMultiplier == null) throw new NoSuchBookException();
        return priceMultiplier;
    }

    public List<PriceMultiplierEntity> getAllPriceMultipliers() {
        return priceMultiplierRepository.findAll();
    }

    @Transactional
    public void createPriceMultiplier(PriceMultiplierEntity priceMultiplier) {
        priceMultiplierRepository.save(priceMultiplier);
    }

    @Transactional
    public void updatePriceMultiplier(PriceMultiplierEntity uPriceMultiplier, String priceMultiplierId) throws NoSuchBookException {

        PriceMultiplierEntity priceMultiplier= priceMultiplierRepository.findById(priceMultiplierId).get();//2.0.0.M7
        if (priceMultiplier == null) throw new NoSuchBookException();
        //update
        priceMultiplier.setPriceCountercol(uPriceMultiplier.getPriceCountercol());


    }

    @Transactional
    public void deletePriceMultiplier(String  priceMultiplierId) throws NoSuchBookException {
        PriceMultiplierEntity priceMultiplier= priceMultiplierRepository.findById(priceMultiplierId).get();//2.0.0.M7

        if (priceMultiplier == null) throw new NoSuchBookException();
        priceMultiplierRepository.delete(priceMultiplier);
    }

}

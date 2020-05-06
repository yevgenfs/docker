package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.BusRepository;

import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.BusEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusService {

    @Autowired
    BusRepository busRepository;





    public BusEntity getBus(Integer busId) throws NoSuchBookException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        BusEntity bus = busRepository.findById(busId).get();//2.0.0.M7
        if (bus == null) throw new NoSuchBookException();
        return bus;
    }

    public List<BusEntity> getAllBuss() {
        return busRepository.findAll();
    }

    @Transactional
    public void createBus(BusEntity bus) {
        busRepository.save(bus);
    }

    @Transactional
    public void updateBus(BusEntity uBusk, Integer busId) throws NoSuchBookException {

        BusEntity bus = busRepository.findById(busId).get();//2.0.0.M7
        if (bus == null) throw new NoSuchBookException();
        //update
        bus.setBusNumber(uBusk.getBusNumber());
        bus.setFreeSeats(uBusk.getFreeSeats());
        bus.setTypeOfBus(uBusk.getTypeOfBus());
        bus.setDepartueDate(uBusk.getDepartueDate());
        bus.setReturnTime(uBusk.getReturnTime());
        bus.setAge(uBusk.getAge());
        bus.setManafacturer(uBusk.getManafacturer());

    }

    @Transactional
    public void deleteBus(Integer busId) throws NoSuchBookException {
        BusEntity userBank = busRepository.findById(busId).get();//2.0.0.M7

        if (userBank == null) throw new NoSuchBookException();
        busRepository.delete(userBank);
    }

}

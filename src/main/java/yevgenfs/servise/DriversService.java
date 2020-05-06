package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.DriversRepository;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.DriversEntity;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriversService {

    @Autowired
    DriversRepository driversRepository;





    public DriversEntity getDrivers(Integer busId) throws NoSuchBookException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        DriversEntity bus = driversRepository.findById(busId).get();//2.0.0.M7
        if (bus == null) throw new NoSuchBookException();
        return bus;
    }

    public List<DriversEntity> getAllDriverss() {
        return driversRepository.findAll();
    }

    @Transactional
    public void createDrivers(DriversEntity bus) {
        driversRepository.save(bus);
    }

    @Transactional
    public void updateDrivers(DriversEntity uDrivers, Integer driversId) throws NoSuchBookException {

        DriversEntity drivers = driversRepository.findById(driversId).get();//2.0.0.M7
        if (drivers == null) throw new NoSuchBookException();
        //update
        drivers.setIdDriver(uDrivers.getIdDriver());
        drivers.setName(uDrivers.getName());
        drivers.setBusNumber(uDrivers.getBusNumber());
        drivers.setPhoneNumber(uDrivers.getPhoneNumber());
        drivers.setLastDrivenBus(uDrivers.getLastDrivenBus());
        drivers.setNumberOfBusChanged(uDrivers.getNumberOfBusChanged());


    }

    @Transactional
    public void deleteDrivers(Integer driversId) throws NoSuchBookException {
        DriversEntity drivers = driversRepository.findById(driversId).get();//2.0.0.M7

        if (drivers == null) throw new NoSuchBookException();
        driversRepository.delete(drivers);
    }


}

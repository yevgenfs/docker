package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.BusEntity;
import yevgenfs.model.DriversEntity;

public class DriversDTO extends ResourceSupport {

    DriversEntity drivers;
    public DriversDTO( DriversEntity drivers, Link selfLink) throws NoSuchBookException {
        this.drivers=drivers;
        add(selfLink);
    }


    public Integer getIdDriver() {
        return drivers.getIdDriver();
    }

    public String getName() {
        return drivers.getName();

    }

    public String getBusNumber() {
        return drivers.getBusNumber();
    }

    public String getPhoneNumber() {
        return drivers.getPhoneNumber();

    }

    public String getLastDrivenBus() {
        return drivers.getLastDrivenBus();
    }

    public Integer getNumberOfBusChanged() {
        return drivers.getNumberOfBusChanged();

    }

}

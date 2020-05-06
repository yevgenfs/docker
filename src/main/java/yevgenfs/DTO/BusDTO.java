package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.BusEntity;
import yevgenfs.model.CityEntity;

public class BusDTO extends ResourceSupport {

    BusEntity bus;
    public BusDTO( BusEntity bus, Link selfLink) throws NoSuchBookException {
        this.bus=bus;
        add(selfLink);
    }

    public Integer getIdBus() {
        return bus.getIdBus();

    }


    public String getBusNumber() {
        return bus.getBusNumber();
    }

    public Integer getFreeSeats() {
        return bus.getFreeSeats();

    }

    public String getTypeOfBus() {
        return bus.getTypeOfBus();
    }

    public String getDepartueDate() {
        return bus.getDepartueDate();

    }

    public String getReturnTime() {
        return bus.getReturnTime();
    }

    public Integer getAge() {
        return bus.getAge();

    }

    public String getManafacturer() {
        return bus.getManafacturer();
    }

}

package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.RoadEntity;
import yevgenfs.model.TiketEntity;

public class TiketDTO extends ResourceSupport {
    TiketEntity tiket;
    public TiketDTO(TiketEntity tiket, Link selfLink) throws NoSuchBookException {
        this.tiket=tiket;
        add(selfLink);
    }

    public Integer getIdorder() {
        return tiket.getIdorder();

    }

    public String getTicetForMan() {
        return tiket.getTicetForMan();

    }

    public String getTicetForChildren() {
        return tiket.getTicetForChildren();
    }

    public String getTicetsForDisablePeople() {
        return tiket.getTicetsForDisablePeople();

    }

    public Integer getExtraLugage() {
        return tiket.getExtraLugage();
    }

    public Integer getUserIduser() {
        return tiket.getUserIduser();

    }

    public Integer getPrice() {
        return tiket.getPrice();
    }


    public Integer getBusIdBus() {
        return tiket.getBusIdBus();
    }

}

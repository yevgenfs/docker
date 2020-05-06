package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.CityEntity;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CityDTO extends ResourceSupport {
    CityEntity city;
    public CityDTO( CityEntity city, Link selfLink) throws NoSuchBookException {
        this.city=city;
        add(selfLink);
    }

    public Integer getCityId() {
        return city.getIdcity();

    }

    public String getCityName() {
        return city.getCityName();
    }



}

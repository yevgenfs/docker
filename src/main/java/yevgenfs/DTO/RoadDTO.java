package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.RoadEntity;


public class RoadDTO extends ResourceSupport  {
    RoadEntity road;
    public RoadDTO(RoadEntity road, Link selfLink) throws NoSuchBookException {
        this.road=road;
        add(selfLink);
    }

    public Integer getIdRoad() {
        return road.getIdRoad();

    }

    public Integer getMileageOfRoad() {
        return road.getMileageOfRoad();
    }

}

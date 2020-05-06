package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.RoadHasIntermidiadStopEntity;

public class RoadHasIntermidiadStopDTO extends ResourceSupport {

    RoadHasIntermidiadStopEntity roadHas;
    public RoadHasIntermidiadStopDTO(RoadHasIntermidiadStopEntity roadHas, Link selfLink) throws NoSuchBookException {
        this.roadHas=roadHas;
        add(selfLink);
    }



    public Integer getNumberOfStop() {
        return roadHas.getNumberOfStop();
    }

}

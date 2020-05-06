package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yevgenfs.DTO.RoadHasIntermidiadStopDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.RoadHasIntermidiadStopEntity;
import yevgenfs.servise.RoadHasIntermidiadStopService;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class RoadHasIntermidiadStopController {


    @Autowired
    RoadHasIntermidiadStopService roadService ;

    @GetMapping(value = "/api/roadHas")
    public ResponseEntity<List<RoadHasIntermidiadStopDTO>> getAllUserBanks() throws NoSuchBookException {
        List<RoadHasIntermidiadStopEntity> cityList = roadService.getAllRoads();
        Link link = linkTo(methodOn(RoadController.class).getAllUserBanks()).withSelfRel();

        List<RoadHasIntermidiadStopDTO> citiesDTO = new ArrayList<>();
        for (RoadHasIntermidiadStopEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getRoadIdRoad()).withSelfRel();
            RoadHasIntermidiadStopDTO dto = new RoadHasIntermidiadStopDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/roadHas/{roadHasId}")
    public ResponseEntity<RoadHasIntermidiadStopDTO> getCity(@PathVariable Integer roadId) throws  NoSuchBookException {
        RoadHasIntermidiadStopEntity user = roadService.getRoad(roadId);
        Link link = linkTo(methodOn(RoadController.class).getCity(roadId)).withSelfRel();

        RoadHasIntermidiadStopDTO cityDTO = new RoadHasIntermidiadStopDTO(user, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/roadHas/{roadHasId}")
    public  ResponseEntity<RoadHasIntermidiadStopDTO> addCity(@RequestBody RoadHasIntermidiadStopEntity newRoad) throws  NoSuchBookException {
        roadService.createRoad(newRoad);
        Link link = linkTo(methodOn(RoadController.class).getCity(newRoad.getRoadIdRoad())).withSelfRel();

        RoadHasIntermidiadStopDTO cityDTO = new RoadHasIntermidiadStopDTO(newRoad, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/roadHas/{roadHasId}")
    public  ResponseEntity<RoadHasIntermidiadStopDTO> updateCity(@RequestBody RoadHasIntermidiadStopEntity uRoad , @PathVariable Integer roadId) throws NoSuchBookException {
        roadService.updateRoad(uRoad, roadId);
        RoadHasIntermidiadStopEntity userBank = roadService.getRoad(roadId);
        Link link = linkTo(methodOn(RoadController.class).getCity(roadId)).withSelfRel();

        RoadHasIntermidiadStopDTO cityDTO = new RoadHasIntermidiadStopDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/roadHas/{roadId}")
    public  ResponseEntity deleteCity(@PathVariable Integer roadId) throws NoSuchBookException {
        roadService.deleteRoad(roadId);
        return new ResponseEntity(HttpStatus.OK);
    }


}

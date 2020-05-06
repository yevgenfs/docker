package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yevgenfs.DTO.RoadDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.RoadEntity;
import yevgenfs.servise.RoadService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class RoadController {

    @Autowired
    RoadService roadService ;

    @GetMapping(value = "/api/road")
    public ResponseEntity<List<RoadDTO>> getAllUserBanks() throws NoSuchBookException {
        List<RoadEntity> cityList = roadService.getAllRoads();
        Link link = linkTo(methodOn(RoadController.class).getAllUserBanks()).withSelfRel();

        List<RoadDTO> citiesDTO = new ArrayList<>();
        for (RoadEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getIdRoad()).withSelfRel();
            RoadDTO dto = new RoadDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/road/{roadId}")
    public ResponseEntity<RoadDTO> getCity(@PathVariable Integer roadId) throws  NoSuchBookException {
        RoadEntity user = roadService.getRoad(roadId);
        Link link = linkTo(methodOn(RoadController.class).getCity(roadId)).withSelfRel();

        RoadDTO cityDTO = new RoadDTO(user, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/road/{roadId}")
    public  ResponseEntity<RoadDTO> addCity(@RequestBody RoadEntity newRoad) throws  NoSuchBookException {
        roadService.createRoad(newRoad);
        Link link = linkTo(methodOn(RoadController.class).getCity(newRoad.getIdRoad())).withSelfRel();

        RoadDTO cityDTO = new RoadDTO(newRoad, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/road/{roadId}")
    public  ResponseEntity<RoadDTO> updateCity(@RequestBody RoadEntity uRoad , @PathVariable Integer roadId) throws NoSuchBookException {
        roadService.updateRoad(uRoad, roadId);
        RoadEntity userBank = roadService.getRoad(roadId);
        Link link = linkTo(methodOn(RoadController.class).getCity(roadId)).withSelfRel();

        RoadDTO cityDTO = new RoadDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/road/{roadId}")
    public  ResponseEntity deleteCity(@PathVariable Integer roadId) throws NoSuchBookException {
        roadService.deleteRoad(roadId);
        return new ResponseEntity(HttpStatus.OK);
    }

}

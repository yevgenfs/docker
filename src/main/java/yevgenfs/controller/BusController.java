package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yevgenfs.DTO.BusDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.BusEntity;
import yevgenfs.servise.BusService;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping(value = "/api/bus")
    public ResponseEntity<List<BusDTO>> getAllUserBanks() throws NoSuchBookException {
        List<BusEntity> cityList = busService.getAllBuss();
        Link link = linkTo(methodOn(TiketController.class).getAllUserBanks()).withSelfRel();

        List<BusDTO> citiesDTO = new ArrayList<>();
        for (BusEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getIdBus()).withSelfRel();
            BusDTO dto = new BusDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/bus/{busId}")
    public ResponseEntity<BusDTO> getCity(@PathVariable Integer busId) throws  NoSuchBookException {
        BusEntity userBank = busService.getBus(busId);
        Link link = linkTo(methodOn(TiketController.class).getCity(busId)).withSelfRel();

        BusDTO cityDTO = new BusDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/bus/{busId}")
    public  ResponseEntity<BusDTO> addCity(@RequestBody BusEntity newBus) throws  NoSuchBookException {
        busService.createBus(newBus);
        Link link = linkTo(methodOn(TiketController.class).getCity(newBus.getIdBus())).withSelfRel();

        BusDTO cityDTO = new BusDTO(newBus, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/bus/{busId}")
    public  ResponseEntity<BusDTO> updateCity(@RequestBody BusEntity uTiket, @PathVariable Integer busId) throws NoSuchBookException {
        busService.updateBus(uTiket, busId);
        BusEntity userBank = busService.getBus(busId);
        Link link = linkTo(methodOn(TiketController.class).getCity(busId)).withSelfRel();

        BusDTO cityDTO = new BusDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/bus/{busId}")
    public  ResponseEntity deleteCity(@PathVariable Integer busId) throws NoSuchBookException {
        busService.deleteBus(busId);
        return new ResponseEntity(HttpStatus.OK);
    }

}

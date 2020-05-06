package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import yevgenfs.DTO.DriversDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.DriversEntity;
import yevgenfs.servise.DriversService;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class DriversController {

    @Autowired
    DriversService driversService;

    @GetMapping(value = "/api/drivers")
    public ResponseEntity<List<DriversDTO>> getAllUserBanks() throws NoSuchBookException {
        List<DriversEntity> cityList = driversService.getAllDriverss();
        Link link = linkTo(methodOn(TiketController.class).getAllUserBanks()).withSelfRel();

        List<DriversDTO> citiesDTO = new ArrayList<>();
        for (DriversEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getIdDriver()).withSelfRel();
            DriversDTO dto = new DriversDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/drivers/{driversId}")
    public ResponseEntity<DriversDTO> getCity(@PathVariable Integer driversId) throws  NoSuchBookException {
        DriversEntity userBank = driversService.getDrivers(driversId);
        Link link = linkTo(methodOn(TiketController.class).getCity(driversId)).withSelfRel();

        DriversDTO cityDTO = new DriversDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/drivers/{driversId}")
    public  ResponseEntity<DriversDTO> addCity(@RequestBody DriversEntity newDrivers) throws  NoSuchBookException {
        driversService.createDrivers(newDrivers);
        Link link = linkTo(methodOn(TiketController.class).getCity(newDrivers.getIdDriver())).withSelfRel();

        DriversDTO cityDTO = new DriversDTO(newDrivers, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/drivers/{driversId}")
    public  ResponseEntity<DriversDTO> updateCity(@RequestBody DriversEntity uTiket, @PathVariable Integer driversId) throws NoSuchBookException {
        driversService.updateDrivers(uTiket, driversId);
        DriversEntity userBank = driversService.getDrivers(driversId);
        Link link = linkTo(methodOn(TiketController.class).getCity(driversId)).withSelfRel();

        DriversDTO cityDTO = new DriversDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/drivers/{driversId}")
    public  ResponseEntity deleteCity(@PathVariable Integer driversId) throws NoSuchBookException {
        driversService.deleteDrivers(driversId);
        return new ResponseEntity(HttpStatus.OK);
    }

}

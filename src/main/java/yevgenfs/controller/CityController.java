package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yevgenfs.DTO.CityDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.CityEntity;
import yevgenfs.servise.CityService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping(value = "/api/city")
    public ResponseEntity<List<CityDTO>> getAllCities() throws NoSuchBookException {
        List<CityEntity> cityList = cityService.getAllCitys();
        Link link = linkTo(methodOn(CityController.class).getAllCities()).withSelfRel();

        List<CityDTO> citiesDTO = new ArrayList<>();
        for (CityEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getIdcity()).withSelfRel();
            CityDTO dto = new CityDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/city/{city_id}")
    public ResponseEntity<CityDTO> getCity(@PathVariable Integer city_id) throws  NoSuchBookException {
        CityEntity city = cityService.getCity(city_id);
        Link link = linkTo(methodOn(CityController.class).getCity(city_id)).withSelfRel();

        CityDTO cityDTO = new CityDTO(city, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/city/{city_id}")
    public  ResponseEntity<CityDTO> addCity(@RequestBody CityEntity newCity) throws  NoSuchBookException {
        cityService.createCity(newCity);
        Link link = linkTo(methodOn(CityController.class).getCity(newCity.getIdcity())).withSelfRel();

        CityDTO cityDTO = new CityDTO(newCity, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/city/{city_id}")
    public  ResponseEntity<CityDTO> updateCity(@RequestBody CityEntity ucity, @PathVariable Integer city_id) throws NoSuchBookException {
        cityService.updateCity(ucity, city_id);
        CityEntity city = cityService.getCity(city_id);
        Link link = linkTo(methodOn(CityController.class).getCity(city_id)).withSelfRel();

        CityDTO cityDTO = new CityDTO(city, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/city/{city_id}")
    public  ResponseEntity deleteCity(@PathVariable Integer city_id) throws NoSuchBookException {
        cityService.deleteCity(city_id);
        return new ResponseEntity(HttpStatus.OK);
    }

}

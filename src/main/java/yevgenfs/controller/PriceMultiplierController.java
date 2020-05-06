package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import yevgenfs.DTO.PriceMltiplierDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.PriceMultiplierEntity;
import yevgenfs.servise.PriceMultiplierService;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class PriceMultiplierController {
    @Autowired
    PriceMultiplierService priceMultiplierService;

    @GetMapping(value = "/api/priceMltiplier")
    public ResponseEntity<List<PriceMltiplierDTO>> getAllPriceMltipliers() throws NoSuchBookException {
        List<PriceMultiplierEntity> cityList = priceMultiplierService.getAllPriceMultipliers();
        Link link = linkTo(methodOn(CityController.class).getAllCities()).withSelfRel();

        List<PriceMltiplierDTO> citiesDTO = new ArrayList<>();
        for (PriceMultiplierEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getTypeOfBus()).withSelfRel();
            PriceMltiplierDTO dto = new PriceMltiplierDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/priceMltiplier/{priceMltiplier_id}")
    public ResponseEntity<PriceMltiplierDTO> getPriceMltiplier(@PathVariable String priceMltiplierId) throws  NoSuchBookException {
        PriceMultiplierEntity user = priceMultiplierService.getPriceMultiplier(priceMltiplierId);
        Link link = linkTo(methodOn(PriceMultiplierController.class).getPriceMltiplier(priceMltiplierId)).withSelfRel();

        PriceMltiplierDTO cityDTO = new PriceMltiplierDTO(user, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/priceMltiplier/{priceMltiplier_id}")
    public  ResponseEntity<PriceMltiplierDTO> addPriceMltiplier(@RequestBody PriceMultiplierEntity newPriceMltiplier) throws  NoSuchBookException {
        priceMultiplierService.createPriceMultiplier(newPriceMltiplier);
        Link link = linkTo(methodOn(PriceMultiplierController.class).getPriceMltiplier(newPriceMltiplier.getTypeOfBus())).withSelfRel();

        PriceMltiplierDTO cityDTO = new PriceMltiplierDTO(newPriceMltiplier, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/priceMltiplier/{priceMltiplier_id}")
    public  ResponseEntity<PriceMltiplierDTO> updatePriceMltiplier(@RequestBody PriceMultiplierEntity uPriceMltiplier, @PathVariable String priceMltiplierId) throws NoSuchBookException {
        priceMultiplierService.updatePriceMultiplier(uPriceMltiplier, priceMltiplierId);
        PriceMultiplierEntity userBank = priceMultiplierService.getPriceMultiplier(priceMltiplierId);
        Link link = linkTo(methodOn(PriceMultiplierController.class).getPriceMltiplier(priceMltiplierId)).withSelfRel();

        PriceMltiplierDTO cityDTO = new PriceMltiplierDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/priceMltiplier/{priceMltiplier_id}")
    public  ResponseEntity deletePriceMltiplier(@PathVariable String userId) throws NoSuchBookException {
        priceMultiplierService.deletePriceMultiplier(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}

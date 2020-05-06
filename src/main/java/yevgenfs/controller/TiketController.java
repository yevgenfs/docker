package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yevgenfs.DTO.TiketDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.TiketEntity;
import yevgenfs.servise.TiketService;
import yevgenfs.servise.UserBankService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class TiketController {


    @Autowired
    TiketService tiketervice;

    @GetMapping(value = "/api/tiket")
    public ResponseEntity<List<TiketDTO>> getAllUserBanks() throws NoSuchBookException {
        List<TiketEntity> cityList = tiketervice.getAllTikets();
        Link link = linkTo(methodOn(TiketController.class).getAllUserBanks()).withSelfRel();

        List<TiketDTO> citiesDTO = new ArrayList<>();
        for (TiketEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getUserIduser()).withSelfRel();
            TiketDTO dto = new TiketDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/tiket/{tiket_id}")
    public ResponseEntity<TiketDTO> getCity(@PathVariable Integer tiketId) throws  NoSuchBookException {
        TiketEntity userBank = tiketervice.getTiket(tiketId);
        Link link = linkTo(methodOn(TiketController.class).getCity(tiketId)).withSelfRel();

        TiketDTO cityDTO = new TiketDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/tiket/{tiket_id}")
    public  ResponseEntity<TiketDTO> addCity(@RequestBody TiketEntity newUserBank) throws  NoSuchBookException {
        tiketervice.createTiket(newUserBank);
        Link link = linkTo(methodOn(TiketController.class).getCity(newUserBank.getUserIduser())).withSelfRel();

        TiketDTO cityDTO = new TiketDTO(newUserBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/tiket/{tiket_id}")
    public  ResponseEntity<TiketDTO> updateCity(@RequestBody TiketEntity uTiket, @PathVariable Integer tiketId) throws NoSuchBookException {
        tiketervice.updateTiket(uTiket, tiketId);
        TiketEntity userBank = tiketervice.getTiket(tiketId);
        Link link = linkTo(methodOn(TiketController.class).getCity(tiketId)).withSelfRel();

        TiketDTO cityDTO = new TiketDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/tiket/{tiket_id}")
    public  ResponseEntity deleteCity(@PathVariable Integer tiketId) throws NoSuchBookException {
        tiketervice.deleteTiket(tiketId);
        return new ResponseEntity(HttpStatus.OK);
    }

}

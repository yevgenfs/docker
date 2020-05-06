package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yevgenfs.DTO.UserBankDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.exceptions.NoSuchCityException;
import yevgenfs.exceptions.NoSuchPersonException;
import yevgenfs.model.UserBankEntity;
import yevgenfs.servise.UserBankService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserBankController {

    @Autowired
    UserBankService userBankService;


    @GetMapping(value = "/api/userBank")
    public ResponseEntity<List<UserBankDTO>> getAllUserBanks() throws NoSuchBookException, NoSuchCityException, NoSuchPersonException {
        List<UserBankEntity> cityList = userBankService.getAllUserBanks();
        Link link = linkTo(methodOn(UserBankController.class).getAllUserBanks()).withSelfRel();

        List<UserBankDTO> citiesDTO = new ArrayList<>();
        for (UserBankEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getUserIduser()).withSelfRel();
            UserBankDTO dto = new UserBankDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/userBank/{userBank_id}")
    public ResponseEntity<UserBankDTO> getCity(@PathVariable Integer UserBankId) throws NoSuchBookException, NoSuchCityException, NoSuchPersonException {
        UserBankEntity userBank = userBankService.getUserBank(UserBankId);
        Link link = linkTo(methodOn(UserBankController.class).getCity(UserBankId)).withSelfRel();

        UserBankDTO cityDTO = new UserBankDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/userBank/{userBank_id}")
    public  ResponseEntity<UserBankDTO> addCity(@RequestBody UserBankEntity newUserBank) throws NoSuchBookException, NoSuchCityException, NoSuchPersonException {
        userBankService.createUserBank(newUserBank);
        Link link = linkTo(methodOn(UserBankController.class).getCity(newUserBank.getUserIduser())).withSelfRel();

        UserBankDTO cityDTO = new UserBankDTO(newUserBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/userBank/{userBank_id}")
    public  ResponseEntity<UserBankDTO> updateCity(@RequestBody UserBankEntity uUserBank, @PathVariable Integer userId) throws NoSuchBookException, NoSuchCityException, NoSuchPersonException {
        userBankService.updateUserBank(uUserBank, userId);
        UserBankEntity userBank = userBankService.getUserBank(userId);
        Link link = linkTo(methodOn(UserBankController.class).getCity(userId)).withSelfRel();

        UserBankDTO cityDTO = new UserBankDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/userBank/{userBank_id}")
    public  ResponseEntity deleteCity(@PathVariable Integer city_id) throws NoSuchBookException {
        userBankService.deleteUserBank(city_id);
        return new ResponseEntity(HttpStatus.OK);
    }

}

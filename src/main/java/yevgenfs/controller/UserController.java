package yevgenfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yevgenfs.DTO.UserDTO;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.UserEntity;
import yevgenfs.servise.UserService;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    UserService userBankService;

    @GetMapping(value = "/api/user")
    public ResponseEntity<List<UserDTO>> getAllUserBanks() throws NoSuchBookException {
        List<UserEntity> cityList = userBankService.getAllUsers();
        Link link = linkTo(methodOn(UserController.class).getAllUserBanks()).withSelfRel();

        List<UserDTO> citiesDTO = new ArrayList<>();
        for (UserEntity entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getIduser()).withSelfRel();
            UserDTO dto = new UserDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/user/{user_id}")
    public ResponseEntity<UserDTO> getCity(@PathVariable Integer UserId) throws  NoSuchBookException {
        UserEntity user = userBankService.getUser(UserId);
        Link link = linkTo(methodOn(UserController.class).getCity(UserId)).withSelfRel();

        UserDTO cityDTO = new UserDTO(user, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/user/{user_id}")
    public  ResponseEntity<UserDTO> addCity(@RequestBody UserEntity newUserBank) throws  NoSuchBookException {
        userBankService.createUser(newUserBank);
        Link link = linkTo(methodOn(UserController.class).getCity(newUserBank.getIduser())).withSelfRel();

        UserDTO cityDTO = new UserDTO(newUserBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/user/{user_id}")
    public  ResponseEntity<UserDTO> updateCity(@RequestBody UserEntity uUser, @PathVariable Integer userId) throws NoSuchBookException {
        userBankService.updateUser(uUser, userId);
        UserEntity userBank = userBankService.getUser(userId);
        Link link = linkTo(methodOn(UserController.class).getCity(userId)).withSelfRel();

        UserDTO cityDTO = new UserDTO(userBank, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/user/{user_id}")
    public  ResponseEntity deleteCity(@PathVariable Integer userId) throws NoSuchBookException {
        userBankService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}

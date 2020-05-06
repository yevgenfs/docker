package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.controller.UserBankController;
import yevgenfs.controller.UserController;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.exceptions.NoSuchCityException;
import yevgenfs.exceptions.NoSuchPersonException;
import yevgenfs.model.CityEntity;
import yevgenfs.model.UserBankEntity;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class UserBankDTO extends ResourceSupport {
    UserBankEntity userBank;
    public UserBankDTO(UserBankEntity userBank, Link selfLink) throws NoSuchBookException, NoSuchCityException, NoSuchPersonException {
        this.userBank=userBank;
        add(selfLink); }

    public Integer getUserIduser() {
        return userBank.getUserIduser();

    }

    public Integer getNumberOfBankAccount() {
        return userBank.getNumberOfBankAccount();
    }


}

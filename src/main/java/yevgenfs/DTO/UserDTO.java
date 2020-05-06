package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.UserEntity;

public class UserDTO extends ResourceSupport {

    UserEntity user;
    public UserDTO(UserEntity user, Link selfLink) throws NoSuchBookException {
        this.user=user;
        add(selfLink);
    }

    public Integer getIduser() {
        return user.getIduser();

    }

    public String getPhoneNumber() {
        return user.getPhoneNumber();
    }
    public String getFirstName() {
        return user.getFirstName();
    }
    public String getLastName() {
        return user.getLastName();
    }
    }
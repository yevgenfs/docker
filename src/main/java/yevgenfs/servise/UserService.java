package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.UserRepository;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.UserEntity;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;



    public UserEntity getUser(Integer userId) throws NoSuchBookException {
        UserEntity user = userRepository.findById(userId).get();//2.0.0.M7
        if (user == null) throw new NoSuchBookException();
        return user;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void createUser(UserEntity userId) {
        userRepository.save(userId);
    }

    @Transactional
    public void updateUser(UserEntity uUser, Integer userId) throws NoSuchBookException {

        UserEntity user= userRepository.findById(userId).get();//2.0.0.M7
        if (user == null) throw new NoSuchBookException();
        //update
        user.setFirstName(uUser.getFirstName());
        user.setLastName(uUser.getLastName());
        user.setPhoneNumber(uUser.getPhoneNumber());
    }

    @Transactional
    public void deleteUser(Integer userId) throws NoSuchBookException {
        UserEntity user= userRepository.findById(userId).get();//2.0.0.M7

        if (user == null) throw new NoSuchBookException();
        userRepository.delete(user);
    }
}

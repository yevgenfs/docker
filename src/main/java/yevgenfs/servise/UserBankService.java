package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.UserBankRepository;
import yevgenfs.Repository.UserRepository;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.exceptions.NoSuchCityException;
import yevgenfs.model.UserBankEntity;
import yevgenfs.model.UserEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserBankService {

    @Autowired
    UserBankRepository userBankRepository;

    @Autowired
    UserRepository userRepository;




    public UserBankEntity getUserBank(Integer userBankId) throws NoSuchBookException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        UserBankEntity userBank = userBankRepository.findById(userBankId).get();//2.0.0.M7
        if (userBank == null) throw new NoSuchBookException();
        return userBank;
    }

    public List<UserBankEntity> getAllUserBanks() {
        return userBankRepository.findAll();
    }

    @Transactional
    public void createUserBank(UserBankEntity userBankId) {
        userBankRepository.save(userBankId);
    }

    @Transactional
    public void updateUserBank(UserBankEntity uUserBank, Integer userBankId) throws NoSuchBookException {

        UserBankEntity userBank = userBankRepository.findById(userBankId).get();//2.0.0.M7
        if (userBank == null) throw new NoSuchBookException();
        //update
        userBank.setNumberOfBankAccount(uUserBank.getNumberOfBankAccount());
    }

    @Transactional
    public void deleteUserBank(Integer userBankId) throws NoSuchBookException {
        UserBankEntity userBank = userBankRepository.findById(userBankId).get();//2.0.0.M7

        if (userBank == null) throw new NoSuchBookException();
        userBankRepository.delete(userBank);
    }

}

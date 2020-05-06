package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.CityRepository;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.CityEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;





    public CityEntity getCity(Integer cityId) throws NoSuchBookException {
        CityEntity city = cityRepository.findById(cityId).get();//2.0.0.M7
        if (city == null) throw new NoSuchBookException();
        return city;
    }

    public List<CityEntity> getAllCitys() {
        return cityRepository.findAll();
    }

    @Transactional
    public void createCity(CityEntity city) {
        cityRepository.save(city);
    }

    @Transactional
    public void updateCity(CityEntity ucity, Integer cityId) throws NoSuchBookException {
        CityEntity city = cityRepository.findById(cityId).get();//2.0.0.M7
        if (city == null) throw new NoSuchBookException();
        //update
        city.setCityName(ucity.getCityName());
    }

    @Transactional
    public void deleteCity(Integer cityId) throws NoSuchBookException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        CityEntity city = cityRepository.findById(cityId).get();//2.0.0.M7

        if (city == null) throw new NoSuchBookException();
        cityRepository.delete(city);
    }
}

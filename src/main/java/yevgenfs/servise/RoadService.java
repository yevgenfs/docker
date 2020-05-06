package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yevgenfs.Repository.RoadRepository;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.RoadEntity;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoadService {

    @Autowired
    RoadRepository roadRepository;



    public RoadEntity getRoad(Integer roadId) throws NoSuchBookException {
        RoadEntity user = roadRepository.findById(roadId).get();//2.0.0.M7
        if (user == null) throw new NoSuchBookException();
        return user;
    }

    public List<RoadEntity> getAllRoads() {
        return roadRepository.findAll();
    }

    @Transactional
    public void createRoad(RoadEntity roadId) {
        roadRepository.save(roadId);
    }

    @Transactional
    public void updateRoad(RoadEntity uRoad, Integer roadId) throws NoSuchBookException {

        RoadEntity road= roadRepository.findById(roadId).get();//2.0.0.M7
        if (road == null) throw new NoSuchBookException();
        //update
        road.setMileageOfRoad(uRoad.getMileageOfRoad());


    }

    @Transactional
    public void deleteRoad(Integer roadId) throws NoSuchBookException {
        RoadEntity road= roadRepository.findById(roadId).get();//2.0.0.M7

        if (road == null) throw new NoSuchBookException();
        roadRepository.delete(road);
    }

}

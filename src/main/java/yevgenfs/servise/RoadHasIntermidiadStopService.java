package yevgenfs.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yevgenfs.Repository.RoadHasIntermidiadStopsRepository;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.RoadHasIntermidiadStopEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoadHasIntermidiadStopService {
    @Autowired
    RoadHasIntermidiadStopsRepository roadHasRepository;



    public RoadHasIntermidiadStopEntity getRoad(Integer roadId) throws NoSuchBookException {
        RoadHasIntermidiadStopEntity user = roadHasRepository.findById(roadId).get();//2.0.0.M7
        if (user == null) throw new NoSuchBookException();
        return user;
    }

    public List<RoadHasIntermidiadStopEntity> getAllRoads() {
        return roadHasRepository.findAll();
    }

    @Transactional
    public void createRoad(RoadHasIntermidiadStopEntity roadId) {
        roadHasRepository.save(roadId);
    }

    @Transactional
    public void updateRoad(RoadHasIntermidiadStopEntity uRoad, Integer roadId) throws NoSuchBookException {

        RoadHasIntermidiadStopEntity road= roadHasRepository.findById(roadId).get();//2.0.0.M7
        if (road == null) throw new NoSuchBookException();
        //update
        road.setNumberOfStop(uRoad.getNumberOfStop());


    }

    @Transactional
    public void deleteRoad(Integer roadId) throws NoSuchBookException {
        RoadHasIntermidiadStopEntity road= roadHasRepository.findById(roadId).get();//2.0.0.M7

        if (road == null) throw new NoSuchBookException();
        roadHasRepository.delete(road);
    }
}

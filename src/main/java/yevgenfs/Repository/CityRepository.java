package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

}

package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.CityEntity;
import yevgenfs.model.RoadEntity;

@Repository
public interface RoadRepository extends JpaRepository<RoadEntity, Integer> {
}

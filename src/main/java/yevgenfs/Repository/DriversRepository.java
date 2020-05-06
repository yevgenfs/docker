package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.CityEntity;
import yevgenfs.model.DriversEntity;

@Repository
public interface DriversRepository extends JpaRepository<DriversEntity, Integer> {
}

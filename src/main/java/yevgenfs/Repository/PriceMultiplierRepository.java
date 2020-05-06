package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.CityEntity;
import yevgenfs.model.PriceMultiplierEntity;

@Repository
public interface PriceMultiplierRepository extends JpaRepository<PriceMultiplierEntity, String> {
}

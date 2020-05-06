package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.RoadHasIntermidiadStopEntity;
import yevgenfs.model.UserBankEntity;

@Repository
public interface RoadHasIntermidiadStopsRepository extends JpaRepository<RoadHasIntermidiadStopEntity, Integer> {

}

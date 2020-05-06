package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.TiketEntity;
import yevgenfs.model.UserBankEntity;

@Repository
public interface TiketRepository extends JpaRepository<TiketEntity, Integer> {
}

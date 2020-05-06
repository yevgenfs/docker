package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.BusEntity;
import yevgenfs.model.UserBankEntity;

@Repository
public interface UserBankRepository extends JpaRepository<UserBankEntity, Integer> {
}

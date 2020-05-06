package yevgenfs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yevgenfs.model.BusEntity;
import yevgenfs.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}

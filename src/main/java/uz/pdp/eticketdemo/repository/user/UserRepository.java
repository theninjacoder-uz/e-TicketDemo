package uz.pdp.eticketdemo.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}


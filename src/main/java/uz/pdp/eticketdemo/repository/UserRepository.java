package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}


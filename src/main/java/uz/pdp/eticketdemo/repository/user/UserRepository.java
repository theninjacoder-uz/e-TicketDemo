package uz.pdp.eticketdemo.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.user.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from users ILIKE first_name = %?1% or ILIKE last_name = %?1%", nativeQuery = true)
    List<UserEntity> getUserEntitiesByFirstOrLastName(String name);

    List<UserEntity> getUserEntitiesByEmail(String email);

    List<UserEntity> getUserEntitiesByPhoneNumber(String phoneNumber);

    List<UserEntity> getUserEntitiesByEmailAndPhoneNumber(String email, String phoneNumber);

    @Query(value = "select * from users ILIKE first_name = %?2% or ILIKE last_name = %?2% where email = ?1", nativeQuery = true)
    List<UserEntity> getUserEntitiesByEmailAndName(String email, String name);

    @Query(value = "select * from users ILIKE first_name = %?2% or ILIKE last_name = %?2% where phone_number = ?1", nativeQuery = true)
    List<UserEntity> getUserEntitiesBPhoneNumberAndName(String phoneNumber, String name);

    @Query(value = "select * from users ILIKE first_name = %?2% or ILIKE last_name = %?2% where phone_number = ?1 and email = ?3", nativeQuery = true)
    List<UserEntity> getUserEntitiesByFilter(String phoneNumber, String name, String email);

    @Query(value = "select (count(u) > 0) from users u where u.phone_number = ?1 and u.password = ?2 and u.user_role & 12 > 0", nativeQuery = true)
    boolean existsAdminByPhoneNumberAndPassword(String phoneNumber, String password);



}


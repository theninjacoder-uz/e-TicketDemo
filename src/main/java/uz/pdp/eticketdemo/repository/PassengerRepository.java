package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

}

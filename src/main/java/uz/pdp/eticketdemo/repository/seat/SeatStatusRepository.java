package uz.pdp.eticketdemo.repository.seat;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.seat.SeatStatusEntity;

public interface SeatStatusRepository extends JpaRepository<SeatStatusEntity, Long> {

}

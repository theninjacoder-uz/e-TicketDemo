package uz.pdp.eticketdemo.repository.seat;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.seat.SeatEntity;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {

}

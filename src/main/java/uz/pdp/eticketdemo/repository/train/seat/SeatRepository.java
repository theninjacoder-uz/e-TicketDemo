package uz.pdp.eticketdemo.repository.train.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.train.seats.SeatEntity;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {

}

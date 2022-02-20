package uz.pdp.eticketdemo.repository.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.seat.SeatTypeEntity;

public interface SeatTypeRepository extends JpaRepository<SeatTypeEntity, Long> {
}

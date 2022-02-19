package uz.pdp.eticketdemo.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.train.SeatTypeEntity;

public interface SeatTypeRepository extends JpaRepository<SeatTypeEntity, Long> {
}

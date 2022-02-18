package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.entity.train.SeatTypeEntity;

public interface SeatTypeRepository extends JpaRepository<SeatTypeEntity, Long> {
}

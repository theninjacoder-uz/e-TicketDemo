package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.SeatTypeEntity;

public interface SeatTypeRepository extends JpaRepository<SeatTypeEntity, Long> {
}

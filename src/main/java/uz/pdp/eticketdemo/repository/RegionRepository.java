package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.PassengerEntity;
import uz.pdp.eticketdemo.model.entity.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {
}

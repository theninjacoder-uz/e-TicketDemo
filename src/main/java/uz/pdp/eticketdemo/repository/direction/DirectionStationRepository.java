package uz.pdp.eticketdemo.repository.direction;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;

public interface DirectionStationRepository extends JpaRepository<DirectionStationEntity, Long> {
}

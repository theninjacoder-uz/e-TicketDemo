package uz.pdp.eticketdemo.repository.direction;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;

public interface DirectionRepository extends JpaRepository<DirectionEntity, Long> {
}

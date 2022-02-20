package uz.pdp.eticketdemo.repository.direction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;

import java.util.List;

public interface DirectionRepository extends JpaRepository<DirectionEntity, Long> {

}

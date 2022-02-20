package uz.pdp.eticketdemo.repository.direction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;

import java.util.List;

public interface DirectionStationRepository extends JpaRepository<DirectionStationEntity, Long> {

    @Query("select d from DirectionStationEntity d where d.direction.id = ?1 order by d.stationOrder")
     List<DirectionStationEntity> getDirectionStationEntitiesByDirectionIdOrderByStationOrder(Long directionId);
}

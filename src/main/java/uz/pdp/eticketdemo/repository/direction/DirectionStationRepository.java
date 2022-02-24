package uz.pdp.eticketdemo.repository.direction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.dto.direction.DirectionStationSearchDto;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public interface DirectionStationRepository extends JpaRepository<DirectionStationEntity, Long> {

    @Query(value = "select d from DirectionStationEntity d where d.direction_id = ?1 order by d.stationOrder", nativeQuery = true)
    List<DirectionStationEntity> getDirectionStationEntitiesByDirectionIdOrderByStationOrder(Long directionId);

    @Modifying
    @Query(value = "update direction_station set station_order = station_order + 1 where direction_id = ?1 and station_order >= ?2", nativeQuery = true)
    boolean updateStationOrder(long directionId, int stationOrder);

    @Query(value = "select * from direction_station d inner join direction_station s on d.direction_id=s.direction_id where d.station_order > s.station_order and d.station_id = ?1 & s.station_id = ?2", nativeQuery = true)
    List<DirectionStationEntity> getDirectionStationEntitiesByTwoStations(Long fromStationId, Long toStationId);
}

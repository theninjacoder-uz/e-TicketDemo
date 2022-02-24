package uz.pdp.eticketdemo.repository.direction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationSearchEntity;

import java.util.List;

public interface DirectionStationSearchRepository extends JpaRepository<DirectionStationSearchEntity, Long> {
    @Query(value = "select fd.directionId, fd.stationOrder, td.stationOrder, fd.stationId, td.stationId from direction_station d inner join direction_station t on d.direction_id = t.direction_id where d.station_order > t.station_order and d.station_id = ?1 & t.station_id = ?2", nativeQuery = true)
    List<DirectionStationSearchEntity> getDirectionStationEntitiesByTwoStations(Long fromStationId, Long toStationId);

}

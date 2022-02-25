package uz.pdp.eticketdemo.repository.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;

import java.util.List;

public interface StationRepository extends JpaRepository<StationEntity, Long> {


    @Query(value = "select * from station where address_id = (select id from address where region_id = ?1)", nativeQuery = true)
    List<StationEntity> getStationsByRegionId(Long regionId);

    @Query(value = "select * from station s where s.directionId = ?1", nativeQuery = true)
    List<DirectionEntity> getDirectionByStationId(Long stationId);
}

package uz.pdp.eticketdemo.repository.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;

import java.util.List;

public interface StationRepository extends JpaRepository<StationEntity, Long> {


//    @Query(value = "select s.id as id, s.name as name from station s inner join address a on s.address_id = a.id " +
//            "where a.region_id = ?1", nativeQuery = true)
//    List<StationEntity> getAllStationsByRegionId(Long regionId);
    @Query("select s from StationEntity s where s.address.regionId in ?1")
    List<StationEntity> getAllByAddressRegionIdIn(Long regionId);
}

package uz.pdp.eticketdemo.repository.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;

import java.util.List;

public interface StationRepository extends JpaRepository<StationEntity, Long> {


//    @Query(value = "select s.id as id, s.name as name from station s inner join address a on s.address_id = a.id " +
//            "where a.region_id = ?1", nativeQuery = true)
//    List<StationEntity> getAllStationsByRegionId(Long regionId);
    @Query("select s from StationEntity s where s.address.regionId in ?1")
    List<StationEntity> getAllByAddressRegionIdIn(Long regionId);

    @Modifying(clearAutomatically = true)
    @Query("update StationEntity s set s.name =:stationName, s.address = :address where s.id =:stationId")
    void editStation(@Param("stationId") Long id, @Param("address") AddressEntity address, @Param("stationName") String name);
}

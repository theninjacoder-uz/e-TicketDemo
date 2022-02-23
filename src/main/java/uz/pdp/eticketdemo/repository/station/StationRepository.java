package uz.pdp.eticketdemo.repository.station;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;

public interface StationRepository extends JpaRepository<StationEntity, Long> {

}

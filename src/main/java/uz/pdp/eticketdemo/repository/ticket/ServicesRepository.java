package uz.pdp.eticketdemo.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.model.entity.ticket.ServicesEntity;

public interface ServicesRepository extends JpaRepository<ServicesEntity, Long> {
}

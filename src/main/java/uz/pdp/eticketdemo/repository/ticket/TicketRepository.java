package uz.pdp.eticketdemo.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.model.entity.ticket.TicketEntity;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    @Query(value = "select * from ticket where from_station_id = ?1 and to_station_id = ?2 and date = ?3", nativeQuery = true)
    List<TicketEntity> getTicketEntitiesByStationsIdAndDate(Long fromStationId, Long toStationId, Date date);

    List<TicketEntity> getTicketEntitiesByUserIdOrderByDateDesc(Long userId);
}

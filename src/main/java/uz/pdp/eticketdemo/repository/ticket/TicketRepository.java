package uz.pdp.eticketdemo.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.ticket.TicketEntity;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

//    List<TicketEntity> getTicketEntitiesByActiveIsTrue();
    
}

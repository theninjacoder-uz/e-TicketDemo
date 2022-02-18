package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.PassengerEntity;
import uz.pdp.eticketdemo.model.entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

}

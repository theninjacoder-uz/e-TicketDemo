package uz.pdp.eticketdemo.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Long> {
}

package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.user.OrderStatusEntity;

public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Long> {
}

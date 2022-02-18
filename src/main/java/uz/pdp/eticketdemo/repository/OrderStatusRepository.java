package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.entity.DocTypeEntity;
import uz.pdp.eticketdemo.entity.OrderStatusEntity;

public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Long> {
}

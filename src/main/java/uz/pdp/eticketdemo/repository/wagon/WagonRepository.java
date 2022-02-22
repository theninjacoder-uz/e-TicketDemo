package uz.pdp.eticketdemo.repository.wagon;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;

public interface WagonRepository extends JpaRepository<WagonEntity, Long> {
}

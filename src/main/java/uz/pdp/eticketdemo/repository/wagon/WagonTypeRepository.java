package uz.pdp.eticketdemo.repository.wagon;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.wagon.WagonType;

public interface WagonTypeRepository extends JpaRepository<WagonType, Long> {
}

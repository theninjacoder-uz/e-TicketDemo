package uz.pdp.eticketdemo.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.dto.train.WagonDto;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;

public interface WagonRepository extends JpaRepository<WagonEntity, Long> {
}

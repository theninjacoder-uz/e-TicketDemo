package uz.pdp.eticketdemo.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;
import uz.pdp.eticketdemo.model.entity.train.WagonTypeEntity;

public interface WagonTypeRepository extends JpaRepository<WagonTypeEntity, Long> {

}

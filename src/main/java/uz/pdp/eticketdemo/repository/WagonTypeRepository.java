package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;

public interface WagonTypeRepository extends JpaRepository<WagonEntity, Long> {

}

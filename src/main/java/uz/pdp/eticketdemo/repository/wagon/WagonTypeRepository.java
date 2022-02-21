package uz.pdp.eticketdemo.repository.wagon;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.pdp.eticketdemo.model.entity.wagon.WagonTypeEntity;

public interface WagonTypeRepository extends JpaRepository<WagonTypeEntity, Long> {
}

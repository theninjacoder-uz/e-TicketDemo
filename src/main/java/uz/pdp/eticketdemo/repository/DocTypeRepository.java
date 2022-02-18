package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.entity.DocTypeEntity;
import uz.pdp.eticketdemo.entity.SeatTypeEntity;

public interface DocTypeRepository extends JpaRepository<DocTypeEntity, Long> {

}

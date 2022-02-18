package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.DocTypeEntity;

public interface DocTypeRepository extends JpaRepository<DocTypeEntity, Long> {

}

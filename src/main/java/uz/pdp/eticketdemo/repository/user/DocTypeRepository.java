package uz.pdp.eticketdemo.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.user.DocTypeEntity;

public interface DocTypeRepository extends JpaRepository<DocTypeEntity, Long> {

}

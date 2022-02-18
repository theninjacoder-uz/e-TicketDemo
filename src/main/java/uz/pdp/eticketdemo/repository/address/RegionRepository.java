package uz.pdp.eticketdemo.repository.address;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.address.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {
}

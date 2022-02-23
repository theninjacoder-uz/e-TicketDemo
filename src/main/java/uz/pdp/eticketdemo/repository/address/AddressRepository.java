package uz.pdp.eticketdemo.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> getAddressEntitiesByRegionId(Long region_id);

}

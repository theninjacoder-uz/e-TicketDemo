package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}

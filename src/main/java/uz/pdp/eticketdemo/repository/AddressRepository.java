package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}

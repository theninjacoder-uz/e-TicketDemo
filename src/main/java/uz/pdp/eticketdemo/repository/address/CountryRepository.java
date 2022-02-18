package uz.pdp.eticketdemo.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.address.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}

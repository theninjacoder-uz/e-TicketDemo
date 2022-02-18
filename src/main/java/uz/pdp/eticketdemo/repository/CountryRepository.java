package uz.pdp.eticketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}

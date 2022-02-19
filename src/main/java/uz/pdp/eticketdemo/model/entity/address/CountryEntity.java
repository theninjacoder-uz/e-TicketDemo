package uz.pdp.eticketdemo.model.entity.address;

import lombok.*;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "country")
public class CountryEntity extends BaseEntity {

    @Column(nullable = false)
    private String country_name;
}

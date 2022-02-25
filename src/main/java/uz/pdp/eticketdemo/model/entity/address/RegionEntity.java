package uz.pdp.eticketdemo.model.entity.address;

import lombok.*;
import uz.pdp.eticketdemo.model.entity.address.CountryEntity;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "region")
public class RegionEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String region;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private CountryEntity country;
}

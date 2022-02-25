package uz.pdp.eticketdemo.model.entity.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "country")
public class CountryEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "country"
    )
    private List<RegionEntity>  region;
}

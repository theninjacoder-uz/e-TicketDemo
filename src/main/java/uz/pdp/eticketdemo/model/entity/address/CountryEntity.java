package uz.pdp.eticketdemo.model.entity.address;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "country")
public class CountryEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "country"
    )
    private Set<RegionEntity> regionList;
}

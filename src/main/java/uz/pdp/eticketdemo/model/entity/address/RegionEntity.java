package uz.pdp.eticketdemo.model.entity.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.thymeleaf.standard.processor.StandardLangXmlLangTagProcessor;
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

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
//    private Set<AddressEntity> address;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private CountryEntity country;
}

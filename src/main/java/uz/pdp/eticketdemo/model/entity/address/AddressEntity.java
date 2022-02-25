package uz.pdp.eticketdemo.model.entity.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private Integer homeNumber;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonProperty("region")
//    private RegionEntity region;
    private long regionId;

}

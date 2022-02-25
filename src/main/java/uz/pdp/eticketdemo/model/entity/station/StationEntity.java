package uz.pdp.eticketdemo.model.entity.station;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "station")
public class StationEntity extends BaseEntity {

    private String name;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private AddressEntity address;

//    @Column(nullable = false)
//    private String streetName;
//
//    @Column(nullable = false)
//    private Integer homeNumber;
//
//    //    @ManyToOne(fetch = FetchType.EAGER)
////    @JsonProperty("region")
////    private RegionEntity region;
//    private long regionId;
}

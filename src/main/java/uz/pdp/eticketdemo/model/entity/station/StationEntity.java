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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private AddressEntity address;
}

package uz.pdp.eticketdemo.model.entity.station;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;

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

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private AddressEntity address;

    @OneToOne(fetch = FetchType.LAZY)
    private DirectionEntity direction;
}

package uz.pdp.eticketdemo.model.entity.station;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "station")
public class StationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NonNull
    @JoinColumn(nullable = false)
    @OneToOne
    private AddressEntity address;

    @Column(updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created_date;
}

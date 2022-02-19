package uz.pdp.eticketdemo.model.entity.address;

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

    @ManyToOne
    private RegionEntity region ;

}

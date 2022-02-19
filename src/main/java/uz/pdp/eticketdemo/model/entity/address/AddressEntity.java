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
@Entity(name = "address")
public class AddressEntity extends BaseEntity {

    @Column(nullable = false)
    private String street_name;

    @Column(nullable = false)
    private Integer home_number;

    @ManyToOne
    private RegionEntity region ;

}

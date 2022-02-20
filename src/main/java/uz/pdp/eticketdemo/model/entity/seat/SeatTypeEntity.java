package uz.pdp.eticketdemo.model.entity.seat;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "seat_type")
public class SeatTypeEntity extends BaseEntity {

    @Column(unique = true)
    private String name = "simple";

    private String description;

}

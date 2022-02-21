package uz.pdp.eticketdemo.model.entity.seat;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "seat")
public class SeatEntity extends BaseEntity {

    private Integer number;

    @ManyToOne
    private WagonEntity wagon;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
//
//    @OneToMany
//    private List<SeatStatusEntity> seatStatus;
//
}

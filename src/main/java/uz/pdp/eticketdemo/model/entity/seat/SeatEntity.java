package uz.pdp.eticketdemo.model.entity.train.seats;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;
import uz.pdp.eticketdemo.model.entity.train.seats.SeatTypeEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "seat")
public class SeatEntity extends BaseEntity {

    private Integer number;

    @ManyToOne
    private WagonEntity wagon;

    @ManyToOne
    private SeatTypeEntity seatType;
//
//    @OneToMany
//    private List<SeatStatusEntity> seatStatus;
//
}

package uz.pdp.eticketdemo.model.entity.seat;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "seat")
public class SeatEntity extends BaseEntity {

    private Integer number;

//    @JoinColumn()
    //TODO use @joinColumn
    @ManyToOne
    private WagonEntity wagon;

    private Integer seatType;

}

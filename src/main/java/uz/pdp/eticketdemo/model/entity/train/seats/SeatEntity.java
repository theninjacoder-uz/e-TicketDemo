package uz.pdp.eticketdemo.model.entity.train;


import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

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

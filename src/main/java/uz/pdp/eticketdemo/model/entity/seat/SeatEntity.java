package uz.pdp.eticketdemo.model.entity.seat;


import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "seat"
    )
    private List<SeatStatusEntity> seatStatus;

}

package uz.pdp.eticketdemo.model.entity.train;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.train.SeatEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "seat_status")
public class SeatStatusEntity extends BaseEntity {


    @ManyToOne
    private SeatEntity seat;

    @Column(columnDefinition = "integer default -1")
    private Integer fromStationOrder;

    @Column(columnDefinition = "integer default -1")
    private Integer toStationOrder;

}

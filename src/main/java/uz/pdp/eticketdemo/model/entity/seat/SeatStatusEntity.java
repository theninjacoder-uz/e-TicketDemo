package uz.pdp.eticketdemo.model.entity.seat;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "seat_status")
public class SeatStatusEntity extends BaseEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    private SeatEntity seat;

    @Column(columnDefinition = "integer default -1")
    private Integer fromStationOrder;

    @Column(columnDefinition = "integer default -1")
    private Integer toStationOrder;

}

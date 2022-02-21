package uz.pdp.eticketdemo.model.entity.train;
package uz.pdp.eticketdemo.model.entity.seat;

import lombok.Getter;
import lombok.Setter;
<<<<<<<<< Temporary merge branch 1:src/main/java/uz/pdp/eticketdemo/model/entity/train/seats/SeatStatusEntity.java
import uz.pdp.eticketdemo.model.entity.train.seats.SeatEntity;
=========
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.train.SeatEntity;

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

package uz.pdp.eticketdemo.model.entity.seat;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "seat_status")
public class SeatStatusEntity extends BaseEntity {

    private long seatId;

    @Column(columnDefinition = "int8 default 1152921504606846976")
    private Long status;

    private long scheduleSeatId;
}

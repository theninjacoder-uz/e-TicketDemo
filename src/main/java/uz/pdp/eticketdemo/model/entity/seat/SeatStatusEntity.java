package uz.pdp.eticketdemo.model.entity.seat;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.seat.SeatEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "seat_status")
public class SeatStatusEntity extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "seat_status_id", nullable = false)
    private SeatEntity seat;

    @Column(columnDefinition = "int8 default 1152921504606846976")
    private Long status;

    private LocalDateTime localDateTime;

}

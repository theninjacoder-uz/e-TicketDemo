package uz.pdp.eticketdemo.model.entity.booking;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class BookingEntity extends BaseEntity {

    private long trainId;
    private long wagonId;
    private long seatId;
    private long directionId;
    private LocalDateTime travelDate;


    private long seatOccupationInterval;
}
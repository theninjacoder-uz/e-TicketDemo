package uz.pdp.eticketdemo.model.entity.booking;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long trainId;
    private long wagonId;
    private long seatId;
    private long directionId;
    private LocalDateTime localDateTime;

    private long seatOccupationInterval;
}
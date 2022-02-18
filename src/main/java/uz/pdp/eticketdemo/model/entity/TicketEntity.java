package uz.pdp.eticketdemo.model.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private PassengerEntity passenger;
    @ManyToOne
    private TrainEntity train;
    @ManyToOne
    private StationEntity fromStation;
    @ManyToOne
    private StationEntity toStation;
    @NonNull
    private Date date;
    @ManyToOne
    private WagonEntity wagon;
    @OneToOne
    private SeatEntity seat;
    @ManyToOne
    private OrderStatusEntity orderStatus;
    @NonNull
    private Double price;

    @Column(updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;


    public TicketEntity() {

    }
}

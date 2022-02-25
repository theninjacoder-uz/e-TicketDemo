package uz.pdp.eticketdemo.model.entity.ticket;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.model.entity.seat.SeatEntity;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.model.entity.user.UserEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;
import uz.pdp.eticketdemo.model.entity.user.PassengerEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class TicketEntity extends BaseEntity {

    @OneToOne
    private PassengerEntity passenger;

    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private TrainEntity train;

    @ManyToOne
    private StationEntity fromStation;

    @ManyToOne
    private StationEntity toStation;

    @NonNull
    private LocalDateTime date;

    @ManyToOne
    private WagonEntity wagon;

    @OneToOne
    private SeatEntity seat;

    private Integer orderStatus;

    @NotBlank
    private Double price;

}

package uz.pdp.eticketdemo.model.dto;

import lombok.Data;
import lombok.NonNull;
import uz.pdp.eticketdemo.model.entity.*;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
public class TicketDto {

    private PassengerEntity passenger;
    private TrainEntity train;
    private StationEntity fromStation;
    private StationEntity toStation;
    private Date date;
    private WagonEntity wagon;
    private SeatEntity seat;
    private OrderStatusEntity orderStatus;


}

package uz.pdp.eticketdemo.model.dto.ticket;

import lombok.Data;
import lombok.NonNull;
import uz.pdp.eticketdemo.model.entity.*;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.model.entity.ticket.OrderStatusEntity;
import uz.pdp.eticketdemo.model.entity.train.SeatEntity;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;
import uz.pdp.eticketdemo.model.entity.user.PassengerEntity;

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

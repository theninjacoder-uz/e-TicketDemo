package uz.pdp.eticketdemo.model.dto.ticket;

import lombok.Data;
import uz.pdp.eticketdemo.model.entity.seat.SeatEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;
import uz.pdp.eticketdemo.model.entity.user.PassengerEntity;

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

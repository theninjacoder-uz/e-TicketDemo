package uz.pdp.eticketdemo.model.dto.station;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public interface StationScheduleDto {

     Long getTrainId();
     Long getAvailableSeatNumbers();
     LocalDateTime getDepartureTime();
     LocalDateTime getArrivalTime();
}

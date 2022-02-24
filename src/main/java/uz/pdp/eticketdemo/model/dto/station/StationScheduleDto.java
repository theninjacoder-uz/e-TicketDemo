package uz.pdp.eticketdemo.model.dto.station;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StationScheduleDto {

    private long trainId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

}

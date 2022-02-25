package uz.pdp.eticketdemo.model.dto.station;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StationScheduleResponseDto {
    private long trainId;
    private long availableSeatNumbers;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}

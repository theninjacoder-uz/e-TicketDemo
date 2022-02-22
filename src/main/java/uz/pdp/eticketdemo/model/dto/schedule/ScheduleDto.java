package uz.pdp.eticketdemo.model.dto.schedule;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class ScheduleDto {

    @NotBlank
    @Size(min = 32, max = 32)
    private long directionId;

    @NotBlank
    private long trainId;

    @NotBlank
    private String startDateTime;

    private int stationStopMinute;

}

package uz.pdp.eticketdemo.model.dto.schedule;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ScheduleSearchDto {

    @NotBlank
    private long fromRegionId;

    @NotBlank
    private long toRegionId;

    @NotBlank
    private String travelDateTime;
}

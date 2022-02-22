package uz.pdp.eticketdemo.model.dto.train.seat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SeatTypeDto {
    private String name;
    private String description;
    private Integer number;
}

package uz.pdp.eticketdemo.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SeatTypeDto {
    private String name;
    private String description;

}

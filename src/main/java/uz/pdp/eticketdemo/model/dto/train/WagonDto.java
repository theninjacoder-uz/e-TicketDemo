package uz.pdp.eticketdemo.model.dto.train;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WagonDto {
    private Integer number;

    private Integer capacity;

    private Integer availableSeatNumber;
}

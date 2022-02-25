package uz.pdp.eticketdemo.model.dto.train;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDto {
    private String name;
    private String model;
    private Integer capacity;
    private Integer availableSeatNumber;
    private double averageSpeed;
}

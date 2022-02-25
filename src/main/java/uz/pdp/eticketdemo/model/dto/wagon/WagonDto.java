package uz.pdp.eticketdemo.model.dto.wagon;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonType;

@Getter
@Setter
public class WagonDto {

    private int number;
    private int capacity;
    private long trainId;
    private double price;
    private int wagonType;
}

package uz.pdp.eticketdemo.model.dto.train;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonType;

@Getter
@Setter
public class WagonDto {

    private int number;

    private Integer capacity;

    private TrainEntity trainEntity;

    private Integer wagonType;
}

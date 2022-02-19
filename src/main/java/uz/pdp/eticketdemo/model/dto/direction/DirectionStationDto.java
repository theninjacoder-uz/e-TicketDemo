package uz.pdp.eticketdemo.model.dto.direction;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;

@Getter
@Setter
public class DirectionStationDto  {
    private String email;
    private String password;
    private Double distanceWithPreviousStation;
    private Double distanceWithNextStation;
    private Integer stationOrder;
}

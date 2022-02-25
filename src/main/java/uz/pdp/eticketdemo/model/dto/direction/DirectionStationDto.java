package uz.pdp.eticketdemo.model.dto.direction;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;

@Getter
@Setter
public class DirectionStationDto {
    private long stationId;
    private long directionId;
    private int stationOrder;
    private double distanceWithNextStation;
}

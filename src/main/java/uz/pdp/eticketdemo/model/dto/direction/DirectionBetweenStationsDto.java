package uz.pdp.eticketdemo.model.dto.direction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectionBetweenStationsDto {

    private Long fromStationId;
    private Integer fromStationOrder;
    private Long toStationId;
    private Integer toStationOrder;
    private Long directionId;
    private Integer numberOfStations;

}

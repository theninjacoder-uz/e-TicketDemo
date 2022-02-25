package uz.pdp.eticketdemo.model.dto.direction;

import lombok.Getter;
import lombok.Setter;

public interface DirectionBetweenStationsDto {

    Long getFromStationId();
     Integer getFromStationOrder();
     Long getToStationId();
     Integer getToStationOrder();
     Long getDirectionId();
//     Integer numberOfStations();

}

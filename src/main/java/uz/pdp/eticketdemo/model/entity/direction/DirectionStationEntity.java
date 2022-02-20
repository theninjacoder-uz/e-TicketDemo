package uz.pdp.eticketdemo.model.entity.direction;

import lombok.*;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "direction_station", uniqueConstraints = {})
public class DirectionStationEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private StationEntity station;


    @ManyToOne(fetch = FetchType.LAZY)
    private DirectionEntity direction;

    private Integer stationOrder;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private StationEntity previousStationId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private StationEntity nextStationId;

    private Double distanceWithPreviousStation;
    private Double distanceWithNextStation;

}

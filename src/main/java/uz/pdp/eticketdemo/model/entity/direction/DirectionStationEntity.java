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
@Table(name = "direction_station", uniqueConstraints = {@UniqueConstraint(columnNames = {"stationId", "directionId"})})
public class DirectionStationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private StationEntity station;
    private long stationId;


//    @ManyToOne(fetch = FetchType.LAZY)
    private long directionId;

    private Integer stationOrder;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private StationEntity previousStationId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private StationEntity nextStationId;

//    private Double distanceWithPreviousStation;
    private Double distanceWithNextStation;
}

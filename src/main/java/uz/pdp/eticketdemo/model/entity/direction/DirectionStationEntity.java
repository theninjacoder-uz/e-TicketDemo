package uz.pdp.eticketdemo.model.entity.direction;

import lombok.*;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "direction_station", uniqueConstraints = {@UniqueConstraint(columnNames = {"stationId", "directionId"})})
public class DirectionStationEntity extends BaseEntity {

    private long stationId;

    private long directionId;

    private Integer stationOrder;

    private Double distanceWithNextStation;
}

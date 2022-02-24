package uz.pdp.eticketdemo.model.entity.direction;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "direction_station", uniqueConstraints = {@UniqueConstraint(columnNames = {"stationId", "directionId"})})
@SqlResultSetMapping(
        name = "DirectionStationDtoMapping",
        classes = {
                @ConstructorResult(
                        targetClass = DirectionStationSearchEntity.class,
                        columns = {
                                @ColumnResult(name = "directionId", type = Long.class),
                                @ColumnResult(name = "fromStationId", type = Long.class),
                                @ColumnResult(name = "toStationId", type = Long.class),
                                @ColumnResult(name = "fromStationOrder", type = Integer.class),
                                @ColumnResult(name = "toStationOrder", type = Integer.class)
                        }
                )
        }
)
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

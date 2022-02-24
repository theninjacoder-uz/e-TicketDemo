package uz.pdp.eticketdemo.model.dto.direction;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import java.util.Collections;
import java.util.List;

public class DirectionStationSearchDto {
    private long directionId;
    private long fromStationId;
    private long toStationId;
    private int fromStationOrder;
    private int toStationOrder;

    public DirectionStationSearchDto(long directionId, long fromStationId, long toStationId, int fromStationOrder, int toStationOrder) {

        this.directionId = directionId;
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
        this.fromStationOrder = fromStationOrder;
        this.toStationOrder = toStationOrder;
    }
}








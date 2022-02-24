package uz.pdp.eticketdemo.model.entity.direction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(name = "getDirectionStation",
        procedureName = "get", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "model_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_out", type = Integer.class)})

public class DirectionStationSearchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long directionId;
    private Long fromStationId;
    private Long toStationId;
    private Integer fromStationOrder;
    private Integer toStationOrder;
}








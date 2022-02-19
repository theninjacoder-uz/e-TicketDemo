package uz.pdp.eticketdemo.model.entity.train;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "wagon")
public class WagonEntity extends BaseEntity {

    @ManyToOne
    private TrainEntity train;

    private Integer number;

    private Integer capacity;

    private Integer availableSeatNumber;

    @ManyToOne
    private WagonTypeEntity wagonType;
}

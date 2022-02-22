package uz.pdp.eticketdemo.model.entity.wagon;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private WagonType wagonType;
}

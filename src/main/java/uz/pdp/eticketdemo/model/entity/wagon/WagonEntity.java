package uz.pdp.eticketdemo.model.entity.wagon;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private TrainEntity train;

    private Integer number;

    private Integer capacity;

    private Integer availableSeatNumber;

    private int wagonType;

    private double price;
}

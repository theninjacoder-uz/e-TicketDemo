package uz.pdp.eticketdemo.model.entity.train;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "train")
public class TrainEntity extends BaseEntity {

    private String name;

    private String model;

    @ManyToOne
    private DirectionEntity direction;

    private Integer capacity;

    private Integer availableSeatNumber;

    private double averageSpeed;

}

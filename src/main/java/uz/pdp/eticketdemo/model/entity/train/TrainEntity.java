package uz.pdp.eticketdemo.model.entity.train;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "train")
public class TrainEntity extends BaseEntity {

    private String name;

    private String model;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "train")
    @JoinTable(name = "train_id")
    private List<WagonEntity> wagon;

    private Integer capacity;

    private Integer availableSeatNumber;

    private double averageSpeed;

}

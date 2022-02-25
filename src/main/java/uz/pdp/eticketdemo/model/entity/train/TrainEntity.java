package uz.pdp.eticketdemo.model.entity.train;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;

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

//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL
//    )
//    @JoinTable(
//            name = "direction_train",
//            joinColumns = {@JoinColumn(name = "direction_id")},
//            inverseJoinColumns = {@JoinColumn(name = "train_id")}
//    )
//    private List<DirectionEntity> directionList;

    private Integer capacity;

    private Integer availableSeatNumber;

    private double averageSpeed;

}

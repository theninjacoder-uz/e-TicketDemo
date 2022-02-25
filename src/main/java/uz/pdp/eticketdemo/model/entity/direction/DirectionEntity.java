package uz.pdp.eticketdemo.model.entity.direction;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "direction")
public class DirectionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @Column(name = "train")
    @JoinTable(
            name = "direction_train",
            inverseJoinColumns = {@JoinColumn(name = "direction_id")},
            joinColumns = {@JoinColumn(name = "train_id")}
    )
    private List<TrainEntity> trainList;
}

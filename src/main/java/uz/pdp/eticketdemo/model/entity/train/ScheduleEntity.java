package uz.pdp.eticketdemo.model.entity.train;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class ScheduleEntity extends BaseEntity {

    private String name;

}

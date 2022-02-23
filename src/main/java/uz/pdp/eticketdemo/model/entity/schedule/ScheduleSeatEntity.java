package uz.pdp.eticketdemo.model.entity.schedule;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "schedule_seat")
public class ScheduleSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String travelStartTime;

    private long train_id;
}

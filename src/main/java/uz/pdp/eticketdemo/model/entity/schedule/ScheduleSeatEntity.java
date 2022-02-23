package uz.pdp.eticketdemo.model.entity.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "schedule_seat")
public class ScheduleSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime travelStartTime;

    private long train_id;

    public ScheduleSeatEntity(LocalDateTime travelStartTime, long train_id) {
        this.travelStartTime = travelStartTime;
        this.train_id = train_id;
    }
}

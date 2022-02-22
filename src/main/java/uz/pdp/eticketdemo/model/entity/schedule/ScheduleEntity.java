package uz.pdp.eticketdemo.model.entity.schedule;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class ScheduleEntity extends BaseEntity {

    private String name;
    private String travelDate;

    private long trainId;
    private long stationId;

    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

//    private boolean trainStatus;
}

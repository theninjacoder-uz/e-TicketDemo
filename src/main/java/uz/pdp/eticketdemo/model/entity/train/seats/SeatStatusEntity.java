package uz.pdp.eticketdemo.model.entity.train.seats;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.train.seats.SeatEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "seat_status")
public class SeatStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SeatEntity seat;

    @Column(columnDefinition = "integer default -1")
    private Integer fromStationOrder;

    @Column(columnDefinition = "integer default -1")
    private Integer toStationOrder;

    @Column(updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

}

package uz.pdp.eticketdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "seat_status")
public class SeatStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "integer default -1")
    private Integer fromStationOrder;
    @Column(columnDefinition = "integer default -1")
    private Integer toStationOrder;

    @Column(updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

}

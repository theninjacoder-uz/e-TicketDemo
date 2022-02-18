package uz.pdp.eticketdemo.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "seat")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;

    @ManyToOne
    private WagonEntity wagon;

    @ManyToOne
    private SeatTypeEntity seatType;
//
//    @OneToMany
//    private List<SeatStatusEntity> seatStatus;
//
    @Column(updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate = new Date();
}

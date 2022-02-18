package uz.pdp.eticketdemo.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passenger_info")
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private UserEntity userEntity;

    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Date birthDate;

    @ManyToOne
    private DocTypeEntity docType;

    @Column(nullable = false)
    private String passportNumber;
    private Date passportExpirationDate;

    @ManyToMany
    private List<CountryEntity> citizenship;

    @Column(updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate = new Date();
}

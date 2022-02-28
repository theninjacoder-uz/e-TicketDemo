package uz.pdp.eticketdemo.model.entity.user;

import lombok.*;
import uz.pdp.eticketdemo.model.entity.address.CountryEntity;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.user.DocTypeEntity;
import uz.pdp.eticketdemo.model.entity.user.UserEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "passenger_info")
public class PassengerEntity extends BaseEntity {

    private long userId;

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

    @ManyToOne
    private CountryEntity citizenship;

}

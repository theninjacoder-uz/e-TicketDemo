package uz.pdp.eticketdemo.model.dto;

import lombok.Data;
import uz.pdp.eticketdemo.model.entity.user.DocTypeEntity;
import uz.pdp.eticketdemo.model.entity.user.UserEntity;

import java.util.Date;

@Data
public class PassengerDto {

    private UserEntity user;

    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
    private DocTypeEntity docType;
    private String passportNumber;
    private Date passportExpirationDate;
//    private CountryEntity citizenship;

}

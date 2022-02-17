package uz.pdp.eticketdemo.dto;

import lombok.Data;
import uz.pdp.eticketdemo.entity.UserEntity;

import java.util.Date;

@Data
public class PassengerDto {

    private UserEntity user;

    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
    private String passportNumber;
    private Date passportExpirationDate;
    private Country citizenship;

}

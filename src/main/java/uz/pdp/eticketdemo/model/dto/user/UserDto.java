package uz.pdp.eticketdemo.model.dto.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    private String email;

    @JsonProperty("username")
    private String phoneNumber;
    private String password;
}

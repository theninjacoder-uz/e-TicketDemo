package uz.pdp.eticketdemo.model.dto.station;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationDto {
    private String name;
    private AddressEntity address;
}

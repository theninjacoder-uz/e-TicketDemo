package uz.pdp.eticketdemo.model.dto.station;

import lombok.Data;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;

@Data
public class StationDto {
    private String name;
    private AddressEntity address;
}

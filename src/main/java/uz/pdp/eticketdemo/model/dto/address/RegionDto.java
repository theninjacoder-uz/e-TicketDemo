package uz.pdp.eticketdemo.model.dto.address;

import lombok.Data;
import uz.pdp.eticketdemo.model.entity.address.CountryEntity;

@Data
public class RegionDto {
    private String region;
    private CountryEntity country;
}

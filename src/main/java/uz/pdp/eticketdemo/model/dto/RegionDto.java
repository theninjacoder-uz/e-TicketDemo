package uz.pdp.eticketdemo.model.dto;

import lombok.Data;
import uz.pdp.eticketdemo.model.entity.CountryEntity;

@Data
public class RegionDto {
    private String region_name;
    private CountryEntity country;
}

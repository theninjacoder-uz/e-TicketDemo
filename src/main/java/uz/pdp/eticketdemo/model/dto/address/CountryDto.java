package uz.pdp.eticketdemo.model.dto.address;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;

@Data
public class CountryDto {
    private String name;

    @Setter
    @Getter
    public static class AddressDto extends AddressEntity {
    }
}

package uz.pdp.eticketdemo.model.dto.address;

import lombok.Data;

@Data
public class AddressDto {
    private int homeNumber;
    private String streetName;
    private long regionId;
}

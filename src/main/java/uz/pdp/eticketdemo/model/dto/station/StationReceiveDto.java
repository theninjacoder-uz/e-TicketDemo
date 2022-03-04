package uz.pdp.eticketdemo.model.dto.station;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationReceiveDto {
    private String name;
    private String streetName;
    private Integer homeNumber;
    private Long regionId;
    private Long countryId;
}

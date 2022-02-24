package uz.pdp.eticketdemo.service.station;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.station.StationDto;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.repository.station.StationRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.address.AddressService;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService extends BaseResponse implements BaseService<StationDto> {
    private final StationRepository stationRepository;
    private final AddressService addressService;

    @Override
    public ApiResponse getList() {
        List<StationEntity> list = stationRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<StationEntity> optional = stationRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = stationRepository.existsById(id);
        if(exists) {
            stationRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, StationDto item) {
        Optional<StationEntity> optional = stationRepository.findById(id);

        if(optional.isPresent()){
            StationEntity station = optional.get();

            station.setName(item.getName());
            station.setAddress(item.getAddress());
            stationRepository.save(station);
            SUCCESS.setData(station);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(StationDto item) {
        StationEntity station=new StationEntity();

        station.setName(item.getName());
        station.setAddress(item.getAddress());
        stationRepository.save(station);

        return SUCCESS;
    }

    public List<StationEntity> getStationsByRegion(Long regionId){
        List<StationEntity> stationList = stationRepository.findAll();
        List<StationEntity> stationsByRegion = new ArrayList<>();
        for (StationEntity station:stationList) {
            for (AddressEntity address: addressService.getAddressesByRegion(regionId)) {
                if (station.getAddress().getId().equals(address.getId())) {
//                    assert false;
                    stationsByRegion.add(station);
                }
            }
        }
        return stationsByRegion;
    }
}

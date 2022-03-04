package uz.pdp.eticketdemo.service.station;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.address.AddressDto;
import uz.pdp.eticketdemo.model.dto.station.StationReceiveDto;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.repository.address.AddressRepository;
import uz.pdp.eticketdemo.repository.station.StationRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.address.AddressService;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService extends BaseResponse implements BaseService<StationReceiveDto> {
    private final StationRepository stationRepository;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

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
    public ApiResponse edit(Long id, StationReceiveDto item) {
        Optional<StationEntity> optional = stationRepository.findById(id);

        if(optional.isPresent()){
            StationEntity station = optional.get();
            station.setName(item.getName());

            AddressDto addressDto = new AddressDto(item.getHomeNumber(), item.getStreetName(), item.getRegionId());
            AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
            AddressEntity save = addressRepository.save(addressEntity);
            station.setName(item.getName());
            station.setAddress(save);

            stationRepository.editStation(id, save, item.getName());
            SUCCESS.setData(station);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(StationReceiveDto item) {

        StationEntity station = new StationEntity();

        AddressDto addressDto = new AddressDto(item.getHomeNumber(), item.getStreetName(), item.getRegionId());
        AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
        AddressEntity save = addressRepository.save(addressEntity);
        station.setName(item.getName());
        station.setAddress(save);

        SUCCESS.setData(stationRepository.save(station));
        return SUCCESS;
    }

    public List<StationEntity> getStationsByRegion(Long regionId){
//        List<StationEntity> stationList = stationRepository.findAll();
//        List<StationEntity> stationsByRegion = new ArrayList<>();
//        for (StationEntity station:stationList) {
//            for (AddressEntity address: addressService.getAddressesByRegion(regionId)) {
//                if (station.getAddress().getId().equals(address.getId())) {
////                    assert false;
//                    stationsByRegion.add(station);
//                }
//            }
//        }
        return stationRepository.getAllByAddressRegionIdIn(regionId);
    }
}

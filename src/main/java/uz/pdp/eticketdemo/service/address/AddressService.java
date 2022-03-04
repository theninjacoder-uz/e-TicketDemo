package uz.pdp.eticketdemo.service.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.eticketdemo.model.dto.address.AddressDto;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;
import uz.pdp.eticketdemo.repository.address.AddressRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressService extends BaseResponse implements BaseService<AddressDto> {

    private final AddressRepository addressRepository;

    @Override
    public ApiResponse getList() {
        List<AddressEntity> findAll = addressRepository.findAll();
        SUCCESS .setData(findAll);
        return SUCCESS;

    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<AddressEntity> findById = addressRepository.findById(id);
        if(findById.isPresent()){
            AddressEntity addressEntity = findById.get();
            SUCCESS.setData(addressEntity);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(@PathVariable Long id) {
        Optional<AddressEntity> findById = addressRepository.findById(id);
        if(findById.isPresent()){
            addressRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, AddressDto item) {
        return null;
    }

    @Override
    public ApiResponse add(AddressDto item) {
        return null;
    }

//    @Override
//    public ApiResponse edit(@PathVariable Long id, @RequestBody CountryDto.AddressDto addressDto) {
//        Optional<AddressEntity> findById = addressRepository.findById(id);
//          if(findById.isPresent()){
//              AddressEntity addressEntity = findById.get();
//              addressEntity.setStreetName(addressDto.getStreetName());
//              addressEntity.setHomeNumber(addressDto.getHomeNumber());
//              addressRepository.save(addressEntity);
//              return SUCCESS;
//          }
//        return NOT_FOUND;
//    }
//
//    @Override
//    public ApiResponse add(AddressDto item) {
//        addressRepository.save(item);
//        return null;
//    }
//    public List<AddressEntity> getAddressesByRegion(Long regionId){
//        return addressRepository.getAddressEntitiesByRegionId(regionId);
//    }

}

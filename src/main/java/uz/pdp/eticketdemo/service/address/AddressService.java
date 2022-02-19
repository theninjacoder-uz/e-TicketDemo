package uz.pdp.eticketdemo.service.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.eticketdemo.model.dto.address.CountryDto;
import uz.pdp.eticketdemo.model.entity.address.AddressEntity;
import uz.pdp.eticketdemo.repository.AddressRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AddressService extends BaseResponse implements BaseService<CountryDto.AddressDto> {

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
    public ApiResponse edit(@PathVariable Long id, @RequestBody CountryDto.AddressDto addressDto) {
        Optional<AddressEntity> findById = addressRepository.findById(id);
          if(findById.isPresent()){
              AddressEntity addressEntity = findById.get();
              addressEntity.setStreet_name(addressDto.getStreet_name());
              addressEntity.setHome_number(addressDto.getHome_number());
              addressRepository.save(addressEntity);
              return SUCCESS;
          }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(CountryDto.AddressDto item) {
        addressRepository.save(item);
        return null;
    }
}

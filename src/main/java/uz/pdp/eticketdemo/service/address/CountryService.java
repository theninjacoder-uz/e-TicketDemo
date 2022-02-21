package uz.pdp.eticketdemo.service.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.address.CountryDto;
import uz.pdp.eticketdemo.model.entity.address.CountryEntity;
import uz.pdp.eticketdemo.repository.address.CountryRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService extends BaseResponse implements BaseService<CountryDto> {
    private final CountryRepository countryRepository;

    @Override
    public ApiResponse getList() {
        List<CountryEntity> list = countryRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<CountryEntity> optional = countryRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = countryRepository.existsById(id);
        if(exists) {
            countryRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, CountryDto item) {
        Optional<CountryEntity> optional = countryRepository.findById(id);

        if(optional.isPresent()){
            CountryEntity country = optional.get();

            country.setCountryName(item.getName());

            countryRepository.save(country);
            SUCCESS.setData(country);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(CountryDto item) {
        CountryEntity country=new CountryEntity();

        country.setCountryName(item.getName());

        countryRepository.save(country);

        return SUCCESS;
    }
}

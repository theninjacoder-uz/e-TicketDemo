package uz.pdp.eticketdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.RegionDto;
import uz.pdp.eticketdemo.model.entity.CountryEntity;
import uz.pdp.eticketdemo.model.entity.RegionEntity;
import uz.pdp.eticketdemo.repository.CountryRepository;
import uz.pdp.eticketdemo.repository.RegionRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService extends BaseResponse implements BaseService<RegionDto>{
    private final RegionRepository regionRepository;
    @Override
    public ApiResponse getList() {
        List<RegionEntity> list = regionRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<RegionEntity> optional = regionRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = regionRepository.existsById(id);
        if(exists) {
            regionRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, RegionDto item) {
        Optional<RegionEntity> optional = regionRepository.findById(id);

        if(optional.isPresent()){
            RegionEntity region = optional.get();

            region.setRegion_name(item.getRegion_name());
            region.setCountry(item.getCountry());

            regionRepository.save(region);
            SUCCESS.setData(region);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(RegionDto item) {
        RegionEntity region=new RegionEntity();

        region.setRegion_name(item.getRegion_name());
        region.setCountry(item.getCountry());

        regionRepository.save(region);

        return SUCCESS;
    }
}

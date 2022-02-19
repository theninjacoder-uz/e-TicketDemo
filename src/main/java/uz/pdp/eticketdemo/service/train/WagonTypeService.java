package uz.pdp.eticketdemo.service.train;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.train.WagonTypeDto;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;
import uz.pdp.eticketdemo.repository.train.WagonTypeRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

import static uz.pdp.eticketdemo.response.BaseResponse.*;

@Service
@RequiredArgsConstructor
public class WagonTypeService implements BaseService<WagonTypeDto> {
    private final WagonTypeRepository wagonTypeRepository;


    @Override
    public ApiResponse getList() {
        List<WagonEntity> wagonEntityList = wagonTypeRepository.findAll();
        SUCCESS.setData(wagonEntityList);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<WagonEntity> wagonEntityOptional = wagonTypeRepository.findById(id);

        if(wagonEntityOptional.isPresent()) {
            SUCCESS.setData(wagonEntityOptional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = wagonTypeRepository.existsById(id);
        if(exists) {
            wagonTypeRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, WagonTypeDto item) {
        Optional<WagonEntity> optionalWagonEntity = wagonTypeRepository.findById(id);
        if(optionalWagonEntity.isPresent()){
            
        }
        return null;
    }

    @Override
    public ApiResponse add(WagonTypeDto item) {
        return null;
    }
}

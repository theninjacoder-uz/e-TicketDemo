package uz.pdp.eticketdemo.service.train.wagon;

import lombok.RequiredArgsConstructor;
import uz.pdp.eticketdemo.model.dto.train.WagonDto;
import uz.pdp.eticketdemo.model.entity.train.WagonEntity;
import uz.pdp.eticketdemo.repository.train.WagonRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class WagonService extends BaseResponse implements BaseService<WagonDto> {

    private final WagonRepository wagonRepository;

    @Override
    public ApiResponse getList() {
        List<WagonEntity> allWagons =
                wagonRepository.findAll();
        SUCCESS.setData(allWagons);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<WagonEntity> optionalWagon = wagonRepository.findById(id);

        if(optionalWagon.isPresent()){
            SUCCESS.setData(optionalWagon.get());
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean existsById = wagonRepository.existsById(id);
        if(existsById){
            wagonRepository.deleteById(id);
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, WagonDto item) {
        Optional<WagonEntity> byId = wagonRepository.findById(id);
        if(byId.isPresent()){
            WagonEntity wagonEntity = byId.get();
            wagonEntity.setNumber(item.getNumber());
            wagonEntity.setCapacity(item.getCapacity());
            wagonEntity.setAvailableSeatNumber(item.getAvailableSeatNumber());

            wagonRepository.save(wagonEntity);
            SUCCESS.setData(wagonEntity);
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(WagonDto item) {
        WagonEntity wagonEntity = new WagonEntity();
        wagonEntity.setNumber(item.getNumber());
        wagonEntity.setCapacity(item.getCapacity());
        wagonEntity.setAvailableSeatNumber(item.getAvailableSeatNumber());

        wagonRepository.save(wagonEntity);
        SUCCESS.setData(wagonEntity);
        return SUCCESS;
    }
}

package uz.pdp.eticketdemo.service.wagon;

import lombok.RequiredArgsConstructor;
import uz.pdp.eticketdemo.exception.CustomNotFoundException;
import uz.pdp.eticketdemo.model.dto.train.WagonDto;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;
import uz.pdp.eticketdemo.repository.wagon.WagonRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;
import uz.pdp.eticketdemo.service.seat.SeatService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class WagonService extends BaseResponse implements BaseService<WagonDto> {

    private final WagonRepository wagonRepository;
    private final SeatService seatService;

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
        wagonEntity.setWagonType(item.getWagonType());
        wagonEntity.setTrain(item.getTrainEntity());

        WagonEntity entity = wagonRepository.save(wagonEntity);
        seatService.generateSeats(entity, item.getCapacity());

        SUCCESS.setData(wagonEntity);
        return SUCCESS;
    }

    private void checkWagon(Long id){
        Optional<WagonEntity> optional = wagonRepository.findById(id);
        if(optional.isEmpty()){
            throw new CustomNotFoundException(id + " Wagon not found");
        }
    }
}

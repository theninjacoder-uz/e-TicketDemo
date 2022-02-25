package uz.pdp.eticketdemo.service.wagon;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.exception.CustomNotFoundException;
import uz.pdp.eticketdemo.model.dto.wagon.WagonDto;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;
import uz.pdp.eticketdemo.repository.wagon.WagonRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;
import uz.pdp.eticketdemo.service.seat.SeatService;
import uz.pdp.eticketdemo.service.train.TrainService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WagonService extends BaseResponse implements BaseService<WagonDto> {

    private final WagonRepository wagonRepository;
    private final ModelMapper modelMapper;
    private final SeatService seatService;
    private final TrainService trainService;

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

        TrainEntity train = (TrainEntity) trainService.getById(item.getTrainId()).getData();
        WagonEntity wagonEntity = new WagonEntity();
        wagonEntity.setTrain(train);
        wagonEntity.setNumber(item.getNumber());
        wagonEntity.setCapacity(item.getCapacity());
        wagonEntity.setWagonType(item.getWagonType());
        wagonEntity.setPrice(item.getPrice());
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

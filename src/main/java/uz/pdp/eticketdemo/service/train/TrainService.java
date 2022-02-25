package uz.pdp.eticketdemo.service.train;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.train.TrainAvailableCapacity;
import uz.pdp.eticketdemo.model.dto.train.TrainDto;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.repository.train.TrainRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TrainService extends BaseResponse implements BaseService<TrainDto> {

    private final TrainRepository trainRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse getList() {
        List<TrainEntity> allTrains = trainRepository.findAll();
        SUCCESS.setData(allTrains);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<TrainEntity> byId = trainRepository.findById(id);
        if(byId.isPresent()){
            SUCCESS.setData(byId.get());
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    public Optional<TrainEntity> getOptionalTrainEntityById(Long id) {
        Optional<TrainEntity> byId = trainRepository.findById(id);
        return byId;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean existsById = trainRepository.existsById(id);
        if(existsById){
            trainRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, TrainDto item) {
        Optional<TrainEntity> findById = trainRepository.findById(id);
        if(findById.isPresent()){
//            TrainEntity trainEntity = findById.get();
//            trainEntity.setName(item.getName());
//            trainEntity.setModel(item.getModel());
//            trainEntity.setCapacity(item.getCapacity());
//            trainEntity.setAvailableSeatNumber(item.getAvailableSeatNumber());
//            trainEntity.setAverageSpeed(item.getAverageSpeed());
            TrainEntity train = modelMapper.map(item, TrainEntity.class);
            trainRepository.save(train);
            SUCCESS.setData(train);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(TrainDto item) {
//        TrainEntity trainEntity = new TrainEntity();
//        trainEntity.setName(item.getName());
//        trainEntity.setModel(item.getModel());
//        trainEntity.setCapacity(item.getCapacity());
//        trainEntity.setAvailableSeatNumber(item.getAvailableSeatNumber());
//        trainEntity.setAverageSpeed(item.getAverageSpeed());
        TrainEntity train = modelMapper.map(item, TrainEntity.class);
        trainRepository.save(train);
        SUCCESS.setData(train);
        return SUCCESS;
    }

    public int getTotalCapacityByWagonType(long trainId, int wagonType){
        TrainAvailableCapacity numbers = trainRepository.getTotalSeatNumbers(trainId, wagonType);
        return numbers == null ? 0 : numbers.getTotalSeats();
    }
}

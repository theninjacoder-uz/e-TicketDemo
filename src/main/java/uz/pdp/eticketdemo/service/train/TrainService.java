package uz.pdp.eticketdemo.service.train;

import lombok.RequiredArgsConstructor;
import uz.pdp.eticketdemo.model.dto.train.TrainDto;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.repository.train.TrainRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TrainService extends BaseResponse implements BaseService<TrainDto> {

    private final TrainRepository repository;

    @Override
    public ApiResponse getList() {
        List<TrainEntity> allTrains = repository.findAll();
        SUCCESS.setData(allTrains);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<TrainEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            SUCCESS.setData(byId.get());
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        return null;
    }

    @Override
    public ApiResponse edit(Long id, TrainDto item) {
        return null;
    }

    @Override
    public ApiResponse add(TrainDto item) {
        return null;
    }
}

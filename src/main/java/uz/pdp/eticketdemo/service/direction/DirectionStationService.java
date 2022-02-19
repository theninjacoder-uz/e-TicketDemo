package uz.pdp.eticketdemo.service.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.eticketdemo.model.dto.direction.DirectionStationDto;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;
import uz.pdp.eticketdemo.repository.direction.DirectionStationRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DirectionStationService extends BaseResponse implements BaseService<DirectionStationDto> {

    private final DirectionStationRepository directionStationRepository;

    @Override
    public ApiResponse getList() {
        List<DirectionStationEntity> allDirections =
                directionStationRepository.findAll();
        SUCCESS.setData(allDirections);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(@PathVariable Long id) {
        Optional<DirectionStationEntity> byId = directionStationRepository.findById(id);
        if(byId.isPresent()){
            SUCCESS.setData(byId.get());
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(@PathVariable Long id) {
        boolean existsById = directionStationRepository.existsById(id);
        if(existsById){
            directionStationRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(@PathVariable Long id, @RequestBody DirectionStationDto item) {
        Optional<DirectionStationEntity> byId = directionStationRepository.findById(id);
        if(byId.isPresent()){
            DirectionStationEntity directionStationEntity = byId.get();
            directionStationEntity.setStationOrder(item.getStationOrder());
            directionStationEntity.setDistanceWithPreviousStation(item.getDistanceWithPreviousStation());
            directionStationEntity.setDistanceWithNextStation(item.getDistanceWithNextStation());
            directionStationEntity.setEmail(item.getEmail());
            directionStationEntity.setPassword(item.getPassword());

            directionStationRepository.save(directionStationEntity);
            SUCCESS.setData(directionStationEntity);
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(DirectionStationDto item) {
        DirectionStationEntity directionStation = new DirectionStationEntity();
        directionStation.setStationOrder(item.getStationOrder());
        directionStation.setEmail(item.getEmail());
        directionStation.setPassword(item.getPassword());
        directionStationRepository.save(directionStation);
        return SUCCESS;
    }
}

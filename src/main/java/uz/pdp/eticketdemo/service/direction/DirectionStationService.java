package uz.pdp.eticketdemo.service.direction;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private final DirectionStationRepository directionStationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse getList() {
        List<DirectionStationEntity> allDirections =
                directionStationRepository.findAll();
        SUCCESS.setData(allDirections);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<DirectionStationEntity> byId = directionStationRepository.findById(id);
        if(byId.isPresent()){
            SUCCESS.setData(byId.get());
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean existsById = directionStationRepository.existsById(id);
        if(existsById){
            directionStationRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, DirectionStationDto item) {
        Optional<DirectionStationEntity> byId = directionStationRepository.findById(id);
        if(byId.isPresent()){

            DirectionStationEntity entity = modelMapper.map(item, DirectionStationEntity.class);
            directionStationRepository.save(entity);

            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(DirectionStationDto item) {

        directionStationRepository.updateStationOrder(item.getDirectionId(), item.getStationOrder());
        DirectionStationEntity entity = modelMapper.map(item, DirectionStationEntity.class);
        directionStationRepository.save(entity);

        return SUCCESS;
    }
}

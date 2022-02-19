package uz.pdp.eticketdemo.service.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.eticketdemo.model.dto.direction.DirectionDto;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;
import uz.pdp.eticketdemo.repository.direction.DirectionRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DirectionService extends BaseResponse implements BaseService<DirectionDto> {

    private final DirectionRepository directionRepository;

    @Override
    public ApiResponse getList() {
        List<DirectionEntity> allDirections = directionRepository.findAll();
        SUCCESS.setData(allDirections);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(@PathVariable Long id) {
        Optional<DirectionEntity> findById = directionRepository.findById(id);
        if (findById.isPresent()) {
            SUCCESS.setData(findById.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(@PathVariable Long id) {
        boolean exists = directionRepository.existsById(id);
        if (exists) {
            directionRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(@PathVariable Long id,  DirectionDto item) {
        Optional<DirectionEntity> optional = directionRepository.findById(id);
        if(optional.isPresent()){
            DirectionEntity directionEntity = optional.get();
            directionEntity.setName(item.getName());
            directionRepository.save(directionEntity);

            SUCCESS.setData(directionEntity);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(@RequestBody DirectionDto item) {
        DirectionEntity direction = new DirectionEntity();
        direction.setName(item.getName());
        directionRepository.save(direction);
        return SUCCESS;
    }
}

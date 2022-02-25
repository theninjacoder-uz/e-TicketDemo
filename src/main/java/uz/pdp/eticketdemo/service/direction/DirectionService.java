package uz.pdp.eticketdemo.service.direction;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.direction.DirectionDto;
import uz.pdp.eticketdemo.model.entity.direction.DirectionEntity;
import uz.pdp.eticketdemo.repository.direction.DirectionRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DirectionService extends BaseResponse implements BaseService<DirectionDto> {

    private final DirectionRepository directionRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse getList() {
        List<DirectionEntity> allDirections = directionRepository.findAll();
        SUCCESS.setData(allDirections);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<DirectionEntity> findById = directionRepository.findById(id);
        if (findById.isPresent()) {
            SUCCESS.setData(findById.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = directionRepository.existsById(id);
        if (exists) {
            directionRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id,  DirectionDto item) {
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
    public ApiResponse add(DirectionDto item) {
//        DirectionEntity direction = new DirectionEntity();
//        direction.setName(item.getName());
        DirectionEntity direction = modelMapper.map(item, DirectionEntity.class);
        SUCCESS.setData(directionRepository.save(direction));
        return SUCCESS;
    }


}

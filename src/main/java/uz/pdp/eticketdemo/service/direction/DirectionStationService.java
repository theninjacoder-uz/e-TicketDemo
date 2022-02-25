package uz.pdp.eticketdemo.service.direction;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.eticketdemo.model.dto.direction.DirectionBetweenStationsDto;
import uz.pdp.eticketdemo.model.dto.direction.DirectionStationDto;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;
import uz.pdp.eticketdemo.model.entity.station.StationEntity;
import uz.pdp.eticketdemo.repository.direction.DirectionStationRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;
import uz.pdp.eticketdemo.service.station.StationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DirectionStationService extends BaseResponse implements BaseService<DirectionStationDto> {

    private final DirectionStationRepository directionStationRepository;
    private final StationService stationService;
    private final ModelMapper modelMapper;

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
        if (byId.isPresent()) {
            SUCCESS.setData(byId.get());
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean existsById = directionStationRepository.existsById(id);
        if (existsById) {
            directionStationRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, DirectionStationDto item) {
        Optional<DirectionStationEntity> byId = directionStationRepository.findById(id);
        if (byId.isPresent()) {

            DirectionStationEntity entity = modelMapper.map(item, DirectionStationEntity.class);
            directionStationRepository.save(entity);

            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(DirectionStationDto item) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
//        directionStationRepository.updateStationOrder(item.getDirectionId(), item.getStationOrder());
        DirectionStationEntity entity = modelMapper.map(item, DirectionStationEntity.class);
        SUCCESS.setData(directionStationRepository.save(entity));

        return SUCCESS;
    }


//    public List<DirectionStationEntity> getDirectionsByTwoStationIds(Long fromStationId, Long toStationId){
//        return directionStationRepository.getDirectionStationEntitiesByTwoStations(fromStationId, toStationId);
//    }

    public List<DirectionBetweenStationsDto> getDirectionsByTwoStations(Long fromRegionId, Long toRegionId) {
//        List<DirectionBetweenStationsDto> directionBetweenStationsDtos = new ArrayList<>();
        List<DirectionBetweenStationsDto> directionStations = new ArrayList<>();
        List<StationEntity> fromStations = stationService.getStationsByRegion(fromRegionId);
        List<StationEntity> toStations = stationService.getStationsByRegion(toRegionId);

        for (StationEntity sFrom : fromStations) {
            for (StationEntity sTo : toStations) {
                 directionStations = directionStationRepository
                        .getDirectionStationEntitiesByTwoStations(sFrom.getId(), sTo.getId());

                for (DirectionBetweenStationsDto directionStation: directionStations) {
                    Integer numberOfStations = directionStationRepository.getNumberOfStationForDirection(directionStation.getDirectionId());
                    directionStation.setNumberOfStations(numberOfStations);
                }


//                for (DirectionStationEntity d : directionStations) {
//                    DirectionBetweenStationsDto dto = new DirectionBetweenStationsDto();
//                    dto.setDirectionId(d.getDirectionId());
//                    dto.setFromStationId(sFrom.getId());
//                    dto.setFromStationOrder(directionStationRepository
//                            .getDirectionStationEntityByStationIdAndDirectionId(sFrom.getId(), d.getDirectionId()).getStationOrder());
//                    dto.setToStationId(sTo.getId());
//                    dto.setToStationOrder(directionStationRepository
//                            .getDirectionStationEntityByStationIdAndDirectionId(sTo.getId(), d.getDirectionId()).getStationOrder());
//                    dto.setNumberOfStations(directionStationRepository.getNumberOfStationForDirection(d.getDirectionId()));
//
//                    directionBetweenStationsDtos.add(dto);
//                }

            }
        }
        return directionStations;
    }

}

package uz.pdp.eticketdemo.service.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.schedule.ScheduleDto;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;
import uz.pdp.eticketdemo.model.entity.schedule.ScheduleEntity;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.repository.direction.DirectionStationRepository;
import uz.pdp.eticketdemo.repository.station.ScheduleRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;
import uz.pdp.eticketdemo.service.train.TrainService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService implements BaseService<ScheduleDto> {

    public final ScheduleRepository scheduleRepository;
    private final DirectionStationRepository directionStationRepository;
    private final TrainService trainService;


    @Override
    public ApiResponse getList() {
        return null;
    }

    @Override
    public ApiResponse getById(Long id) {
        return null;
    }

    @Override
    public ApiResponse delete(Long id) {
        return null;
    }

    @Override
    public ApiResponse edit(Long id, ScheduleDto item) {
        return null;
    }

    @Override
    public ApiResponse add(ScheduleDto item) {
        return null;
    }

    public ApiResponse generateScheduleForTrain(Long directionId, Long trainId, String startDateTime, Integer stationStopMinutes){
        List<DirectionStationEntity> directionStationList = directionStationRepository.getDirectionStationEntitiesByDirectionIdOrderByStationOrder(directionId);
        Optional<TrainEntity> optionalTrainEntityById = trainService.getOptionalTrainEntityById(directionId);
        if(optionalTrainEntityById.isEmpty())
            return BaseResponse.NOT_FOUND;

        TrainEntity train = optionalTrainEntityById.get();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(startDateTime, formatter);

        for (DirectionStationEntity directionStation : directionStationList) {
            ScheduleEntity schedule = new ScheduleEntity();
            dateTime = dateTime.plusMinutes(stationStopMinutes);

            schedule.setTrainId(trainId);
            schedule.setArrivalTime(dateTime);
            schedule.setDepartureTime(dateTime);
            schedule.setStationId(directionStation.getStationId());
            schedule.setTrainStatus(true);

            Double distanceWithNextStation = directionStation.getDistanceWithNextStation();
            int minutes = (int) (distanceWithNextStation / train.getAverageSpeed() * 60);

            dateTime = dateTime.plusMinutes(minutes);
            scheduleRepository.save(schedule);
        }

        //TODO some optimizations needed

        return BaseResponse.SUCCESS;
    }
}

package uz.pdp.eticketdemo.service.schedule;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;


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

    //Generate schedule by directionStationList, trainId and travel start dateTime
    public ApiResponse generateScheduleForTrain(ScheduleDto scheduleDto){

        //Date for searching schedule

        //Parse String to DateTime
        LocalDateTime dateTime = LocalDateTime.parse(scheduleDto.getStartDateTime(), DateTimeFormatter.ofPattern("yyyy-DD-mm HH:mm"));

        int year = dateTime.getYear();
        int dayOfMonth = dateTime.getDayOfMonth();
        int month = dateTime.getMonth().getValue();

        String travelDate = year + "-" + month  + "-" + dayOfMonth; // "yyyy-DD-mm";


        List<DirectionStationEntity> directionStationList = directionStationRepository.getDirectionStationEntitiesByDirectionIdOrderByStationOrder(scheduleDto.getDirectionId());
        Optional<TrainEntity> optionalTrainEntityById = trainService.getOptionalTrainEntityById(scheduleDto.getTrainId());
        //TODO use function to find directionStationList and train by id;

        if(optionalTrainEntityById.isEmpty())
            return BaseResponse.NOT_FOUND;
        //TODO use exception

        Long trainId = optionalTrainEntityById.get().getId();


        for (DirectionStationEntity directionStation : directionStationList) {

            ScheduleEntity schedule = new ScheduleEntity();
            schedule.setTrainId(trainId);

            //setting date
            schedule.setArrivalTime(dateTime);
            dateTime = dateTime.plusMinutes(scheduleDto.getStationStopMinute());
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

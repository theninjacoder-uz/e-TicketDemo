package uz.pdp.eticketdemo.service.schedule;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.direction.DirectionBetweenStationsDto;
import uz.pdp.eticketdemo.model.dto.schedule.ScheduleDto;
import uz.pdp.eticketdemo.model.dto.schedule.ScheduleSearchDto;
import uz.pdp.eticketdemo.model.dto.station.StationScheduleDto;
import uz.pdp.eticketdemo.model.entity.direction.DirectionStationEntity;
import uz.pdp.eticketdemo.model.entity.schedule.ScheduleEntity;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;
import uz.pdp.eticketdemo.repository.direction.DirectionStationRepository;
import uz.pdp.eticketdemo.repository.schedule.ScheduleRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;
import uz.pdp.eticketdemo.service.booking.BookingService;
import uz.pdp.eticketdemo.service.direction.DirectionStationService;
import uz.pdp.eticketdemo.service.station.StationService;
import uz.pdp.eticketdemo.service.train.TrainService;

import javax.persistence.EntityManager;
import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduleService implements BaseService<ScheduleDto> {

    public final ScheduleRepository scheduleRepository;
//    public final ScheduleSeatRepository scheduleSeatRepository;
    private final DirectionStationRepository directionStationRepository;
    private final DirectionStationService directionStationService;
    private final TrainService trainService;
    private final BookingService bookingService;
    private final StationService stationService;
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;


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

        //Parse String to DateTime
        LocalDateTime dateTime = LocalDateTime.parse(scheduleDto.getStartDateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime travelDate = LocalDateTime.parse(scheduleDto.getStartDateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));


        List<DirectionStationEntity> directionStationList = directionStationRepository.getDirectionStationEntitiesByDirectionIdOrderByStationOrder(scheduleDto.getDirectionId());
        Optional<TrainEntity> optionalTrainEntityById = trainService.getOptionalTrainEntityById(scheduleDto.getTrainId());
        //TODO use function to find directionStationList and train by id;

        if(optionalTrainEntityById.isEmpty())
            return BaseResponse.NOT_FOUND;
        //TODO use exception

        TrainEntity train = optionalTrainEntityById.get();

        // save schedule_seat entity
//        scheduleSeatRepository.save(new ScheduleSeatEntity(travelDate, train.getId()));

        for (DirectionStationEntity directionStation : directionStationList) {

            ScheduleEntity schedule = new ScheduleEntity();
            schedule.setTrainId(train.getId());
            schedule.setTravelDate(travelDate);

            //setting date
            schedule.setArrivalTime(dateTime);
            dateTime = dateTime.plusMinutes(scheduleDto.getStationStopMinute());
            schedule.setDepartureTime(dateTime);

            schedule.setStationId(directionStation.getStationId());

            Double distanceWithNextStation = directionStation.getDistanceWithNextStation();
            int minutes = (int) (distanceWithNextStation / train.getAverageSpeed() * 60);

            dateTime = dateTime.plusMinutes(minutes);
            scheduleRepository.save(schedule);
        }

        //TODO some optimizations needed
        return BaseResponse.SUCCESS;
    }

    public ApiResponse getAvailableTrainMap(ScheduleSearchDto searchDto){
        //TODO get station order list from Madina's method
        //List<someDto> dtoList =  StationService.getDirectionStation(searchDto.getFromId(), searchDto.getToId);


//        List<DirectionStationSearchEntity> stationSearchDtoList = entityManager.createQuery(
//                "select fd.directionId, fd.stationOrder, td.stationOrder, fd.stationId, td.stationId from DirectionStationEntity fd inner join DirectionStationEntity td" +
//                        " on fd.directionId = td.directionId where fd.stationOrder = td.stationOrder and fd.stationId = " + 1 + " and td.stationId = " + 2,
//                DirectionStationSearchEntity.class
//                ).getResultList();

        List<DirectionBetweenStationsDto> directionsByTwoStations
                = directionStationService.getDirectionsByTwoStations(searchDto.getFromRegionId(), searchDto.getToRegionId());
        //TODO increase number of stations if you needed

//        Map<> availableSchedules = new HashMap<>();

        List<StationScheduleDto> responseList = new ArrayList<>();

//        Map<StationScheduleDto, Long> responseMap = new HashMap<>();

        for (DirectionBetweenStationsDto twoStation : directionsByTwoStations) {
//            Integer numberOfStations = twoStation.getNumberOfStations();

            Integer fromStationOrder = twoStation.getFromStationOrder();
            Integer toStationOrder = twoStation.getToStationOrder();

            LocalDateTime startTime = LocalDateTime.parse(searchDto.getTravelDateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDateTime endTime = startTime.plusDays(1);


            List<StationScheduleDto> stationSchedules =
                    scheduleRepository.getStationsScheduleByDate(startTime,endTime, twoStation.getFromStationId(), twoStation.getToStationId());
            // TODO check available seats by train_id and wagon_type

            for (StationScheduleDto stationSchedule : stationSchedules) {
                long trainId = stationSchedule.getTrainId();
                long occupiedSeatNumbers = bookingService.getOccupiedSeatNumbers(fromStationOrder, toStationOrder, trainId, startTime);
                int capacityBusinessClass = trainService.getTotalCapacityByWagonType(trainId, 1);
                int capacityFirstClass = trainService.getTotalCapacityByWagonType(trainId, 2);
                int capacityEconomyClass = trainService.getTotalCapacityByWagonType(trainId, 4);

                long availableSeats = capacityEconomyClass + capacityBusinessClass+capacityFirstClass - occupiedSeatNumbers;

//                responseMap.put(stationSchedule, availableSeats);
                stationSchedule.setAvailableSeatNumbers(availableSeats);
                responseList.add(stationSchedule);
            }
        }
        BaseResponse.SUCCESS.setData(responseList);
        return BaseResponse.SUCCESS;
    }
}

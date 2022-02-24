package uz.pdp.eticketdemo.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.dto.station.StationScheduleDto;
import uz.pdp.eticketdemo.model.entity.schedule.ScheduleEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    @Query(value = "select * from station st join address ad on where st.id = ?1 or st.id =?2 ", nativeQuery = true)
    List<Object> getAllSchedule(Long fId, Long tId);

    @Query(value = "select fsc.train_id as train_id, fsc.departure_time as departure_time, ssc.arrival_time as arrival_time from schedule fsc inner join schedule ssc on fsc.train_id = ssc.train_id where travel_date=?1 and fsc.station_id = ?2 and ssc.station_id = ?3", nativeQuery = true)
    List<StationScheduleDto> getStationsScheduleByDate(LocalDateTime travelDate, Long fromStationId, Long toStationId);

}

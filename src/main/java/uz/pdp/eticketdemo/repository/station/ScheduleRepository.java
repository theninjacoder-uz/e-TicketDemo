package uz.pdp.eticketdemo.repository.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.train.ScheduleEntity;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    @Query(value = "select * from station st join address ad on where st.id = ?1 or st.id =?2 ", nativeQuery = true)
    List<Object> getAllSchedule(Long fId, Long tId);
}

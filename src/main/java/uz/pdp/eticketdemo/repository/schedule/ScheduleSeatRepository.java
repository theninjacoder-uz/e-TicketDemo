package uz.pdp.eticketdemo.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.schedule.ScheduleSeatEntity;

public interface ScheduleSeatRepository extends JpaRepository<ScheduleSeatEntity, Long> {

}

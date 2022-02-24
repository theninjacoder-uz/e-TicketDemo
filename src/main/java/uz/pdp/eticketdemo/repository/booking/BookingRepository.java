package uz.pdp.eticketdemo.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.booking.BookingEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query("select b from booking b where b.trainId = ?1 and b.travelDate = ?2")
    List<BookingEntity> getAllByTrainIdAndTravelDate(Long trainId, LocalDateTime travelDate);
}

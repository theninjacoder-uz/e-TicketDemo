package uz.pdp.eticketdemo.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.eticketdemo.model.entity.booking.BookingEntity;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    @Query(value = "select * from booking b where b.train_id = ?1 and b.travel_date >= ?2 and b.travel_date < ?3", nativeQuery = true)
    List<BookingEntity> getAllByTrainIdAndTravelDate(Long trainId, LocalDateTime startDate, LocalDateTime endDate);
}

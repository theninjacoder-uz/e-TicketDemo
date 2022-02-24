package uz.pdp.eticketdemo.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;


public interface TrainRepository extends JpaRepository<TrainEntity, Long> {

    @Query(value = "select sum(capacity) from wagon where train_id = ?1 and wagon_type = ?2 ", nativeQuery = true)
    int getTotalSeatNumbers(Long trainId, Integer wagonType);

}

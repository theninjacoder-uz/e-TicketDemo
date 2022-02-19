package uz.pdp.eticketdemo.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;

public interface TrainRepository_B extends JpaRepository<TrainEntity, Long> {

//    @Query(value = "", nativeQuery = true));
    boolean findAllByRegion(Long from_id, Long to_id);
}

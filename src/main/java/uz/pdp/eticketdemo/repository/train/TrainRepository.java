package uz.pdp.eticketdemo.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticketdemo.model.entity.train.TrainEntity;


public interface TrainRepository extends JpaRepository<TrainEntity, Long> {
}

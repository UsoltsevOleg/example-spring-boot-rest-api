package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springbootapp.entities.SteeringWheel;

public interface SteeringWheelRepository  extends CrudRepository<SteeringWheel, Long>, JpaRepository<SteeringWheel, Long> {
}

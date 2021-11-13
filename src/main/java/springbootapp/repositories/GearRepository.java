package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.entities.Car;
import springbootapp.entities.Gear;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GearRepository  extends CrudRepository<Car, Long>, JpaRepository<Car, Long> {

    Gear findGearByEngineId(Long engineId);

    List<Gear> findGearsByEngineId(Long engineId);

}

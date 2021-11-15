package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.entities.Gear;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GearRepository extends CrudRepository<Gear, Long>, JpaRepository<Gear, Long> {

    Gear findGearByEngineId(Long engineId);

    List<Gear> findGearsByEngineId(Long engineId);

}

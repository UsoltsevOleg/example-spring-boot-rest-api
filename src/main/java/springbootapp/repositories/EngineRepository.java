package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.entities.Engine;
import org.springframework.data.repository.CrudRepository;

public interface EngineRepository extends CrudRepository<Engine, Long>, JpaRepository<Engine, Long> {
}

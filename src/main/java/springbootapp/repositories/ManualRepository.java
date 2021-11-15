package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springbootapp.entities.Manual;

public interface ManualRepository extends CrudRepository<Manual, Long>, JpaRepository<Manual, Long> {
}

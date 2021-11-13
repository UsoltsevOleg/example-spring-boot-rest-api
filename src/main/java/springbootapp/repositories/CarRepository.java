package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springbootapp.entities.Car;

public interface CarRepository extends CrudRepository<Car, Long>, JpaRepository<Car, Long> {
}

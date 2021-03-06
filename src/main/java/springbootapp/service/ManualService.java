package springbootapp.service;

import springbootapp.entities.Car;
import springbootapp.entities.Manual;

import java.util.Optional;

public interface ManualService {

    Optional<Manual> findByID(long id);
    Manual update(Manual manual);
    void remove(long id);
    Manual save(Manual manual);
    Manual getByID(long id);
}

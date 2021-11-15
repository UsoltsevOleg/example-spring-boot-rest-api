package springbootapp.service;

import springbootapp.entities.Car;
import springbootapp.entities.Engine;

import java.util.Optional;

public interface EngineService {

    Optional<Engine> findByID(long id);
    Engine update(Engine engine);
    void remove(long id);
    Engine save(Engine engine);
    Engine getByID(long id);
}

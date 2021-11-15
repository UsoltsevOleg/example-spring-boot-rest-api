package springbootapp.service;

import springbootapp.entities.Car;

import java.util.Optional;

public interface CarService {

    Car addCar(String mnfName, String modelName, String engineType);
    Optional<Car> findByID(long id);
    Car update(Car car);
    void remove(long id);
    Car save(Car car);
    Car getByID(long id);
}

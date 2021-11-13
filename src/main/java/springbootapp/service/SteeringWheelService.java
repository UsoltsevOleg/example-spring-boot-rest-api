package springbootapp.service;

import springbootapp.entities.Car;
import springbootapp.entities.SteeringWheel;

import java.util.Optional;

public interface SteeringWheelService {

    Optional<SteeringWheel> getByID(long id);
    SteeringWheel update(SteeringWheel steeringWheel);
    void remove(long id);
    SteeringWheel save(SteeringWheel steeringWheel);
}

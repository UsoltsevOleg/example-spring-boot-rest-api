package springbootapp.service;

import springbootapp.entities.Car;
import springbootapp.entities.Engine;
import springbootapp.entities.Gear;

import java.util.List;
import java.util.Optional;

public interface GearService {

    Gear findGear(Car car);
    List<Gear> findGears(Car car);
    Optional<Gear> findByID(long id);
    Gear update(Gear gear);
    void remove(long id);
    Gear save(Gear gear);
    Gear getByID(long id);
}

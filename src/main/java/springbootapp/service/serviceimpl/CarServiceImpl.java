package springbootapp.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootapp.entities.*;
import springbootapp.repositories.CarRepository;
import springbootapp.service.CarService;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(String mnfName, String modelName, String engineType) {
        final Car newCar = new Car(mnfName, modelName);

        final SteeringWheel steeringWheel = new SteeringWheel(String.join(" ", newCar.getManufacturerName(),newCar.getModelName(),"steering wheel"));
        newCar.setSteeringWheel(steeringWheel);

        Engine engine = new Engine(engineType);
        for (int i = 5; i <= 10; i++) {
            final Gear gear = new Gear(i);
            gear.setEngine(engine);
            engine.getGears().add(gear);
        }
        newCar.setEngine(engine);

        Manual cylinderHeadManual = new Manual("Cylinder head manual for " + engineType);
        engine.getManuals().add(cylinderHeadManual);
        cylinderHeadManual.getEngines().add(engine);
        Manual electricManual = new Manual("Electrics manual for " + engineType);
        engine.getManuals().add(electricManual);
        electricManual.getEngines().add(engine);

        return carRepository.save(newCar);
    }

    @Override
    public Optional<Car> findByID(long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car update(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public void remove(long id) {
        carRepository.deleteById(id);;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getByID(long id) {
        return carRepository.getById(id);
    }
}

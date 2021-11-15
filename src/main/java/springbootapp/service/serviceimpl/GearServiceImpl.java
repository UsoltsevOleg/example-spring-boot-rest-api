package springbootapp.service.serviceimpl;

import springbootapp.entities.Car;
import springbootapp.entities.Gear;
import springbootapp.repositories.CarRepository;
import springbootapp.repositories.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootapp.service.GearService;

import java.util.List;
import java.util.Optional;

@Service
public class GearServiceImpl implements GearService {

    @Autowired
    private GearRepository gearRepository;

    @Override
    public Gear findGear(Car car) {
        return gearRepository.findGearByEngineId(car.getEngine().getId());
    }

    @Override
    public List<Gear> findGears(Car car) {
        return gearRepository.findGearsByEngineId(car.getEngine().getId());
    }

    @Override
    public Optional<Gear> findByID(long id) {
        return gearRepository.findById(id);
    }

    @Override
    public Gear update(Gear gear) {
        return gearRepository.saveAndFlush(gear);
    }

    @Override
    public void remove(long id) {
        gearRepository.deleteById(id);;
    }

    @Override
    public Gear save(Gear gear) {
        return gearRepository.save(gear);
    }

    @Override
    public Gear getByID(long id) {
        return gearRepository.getById(id);
    }
}

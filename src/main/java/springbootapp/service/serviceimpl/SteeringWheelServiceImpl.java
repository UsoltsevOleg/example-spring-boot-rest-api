package springbootapp.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import springbootapp.entities.Car;
import springbootapp.entities.SteeringWheel;
import springbootapp.repositories.CarRepository;
import springbootapp.repositories.SteeringWheelRepository;
import springbootapp.service.SteeringWheelService;

import java.util.Optional;

public class SteeringWheelServiceImpl implements SteeringWheelService {

    @Autowired
    private SteeringWheelRepository steeringWheelRepository;

    @Override
    public Optional<SteeringWheel> getByID(long id) {
        return steeringWheelRepository.findById(id);
    }

    @Override
    public SteeringWheel update(SteeringWheel steeringWheel) {
        return steeringWheelRepository.saveAndFlush(steeringWheel);
    }

    @Override
    public void remove(long id) {
        steeringWheelRepository.deleteById(id);;
    }

    @Override
    public SteeringWheel save(SteeringWheel steeringWheel) {
        return steeringWheelRepository.save(steeringWheel);
    }
}

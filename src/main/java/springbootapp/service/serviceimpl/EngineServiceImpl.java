package springbootapp.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import springbootapp.entities.Car;
import springbootapp.entities.Engine;
import springbootapp.repositories.CarRepository;
import springbootapp.repositories.EngineRepository;
import springbootapp.service.EngineService;

import java.util.Optional;

public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Optional<Engine> findByID(long id) {
        return engineRepository.findById(id);
    }

    @Override
    public Engine update(Engine engine) {
        return engineRepository.saveAndFlush(engine);
    }

    @Override
    public void remove(long id) {
        engineRepository.deleteById(id);;
    }

    @Override
    public Engine save(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Engine getByID(long id) {
        return engineRepository.getById(id);
    }
}

package springbootapp.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import springbootapp.entities.Car;
import springbootapp.entities.Manual;
import springbootapp.repositories.CarRepository;
import springbootapp.repositories.ManualRepository;
import springbootapp.service.ManualService;

import java.util.Optional;

public class ManualServiceImpl implements ManualService {

    @Autowired
    private ManualRepository manualRepository;

    @Override
    public Optional<Manual> getByID(long id) {
        return manualRepository.findById(id);
    }

    @Override
    public Manual update(Manual manual) {
        return manualRepository.saveAndFlush(manual);
    }

    @Override
    public void remove(long id) {
        manualRepository.deleteById(id);;
    }

    @Override
    public Manual save(Manual manual) {
        return manualRepository.save(manual);
    }
}

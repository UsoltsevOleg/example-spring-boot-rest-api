package springbootapp.controllers;

import com.example.boot.starter.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Car;
import springbootapp.entities.Engine;
import springbootapp.repositories.EngineRepository;
import springbootapp.service.serviceimpl.CarServiceImpl;
import springbootapp.service.serviceimpl.EngineServiceImpl;

import java.util.Optional;

@RestController
public class EngineController {

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private EngineServiceImpl engineService;

    @RequestMapping(value = "/api/engine/read/{id}", method = RequestMethod.GET)
    public Optional<Engine> getEngine(long id) {
        Optional<Engine> engine = engineService.getByID(id);
        return engine;
    }

    @RequestMapping(value = "/api/engine/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateEngine(@RequestBody Engine engine) {
        return new ResponseEntity<>(engineService.update(engine), HttpStatus.UPGRADE_REQUIRED);
    }

    @RequestMapping(value = "/api/engine/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteEngine(@PathVariable long id) {
        Optional<Engine> engine = engineService.getByID(id);
        engineService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/engine/create", method = RequestMethod.POST)
    public ResponseEntity<?> createEngine(@RequestBody Engine engine) {
        return new ResponseEntity<>(engineService.save(engine), HttpStatus.CREATED);
    }
}

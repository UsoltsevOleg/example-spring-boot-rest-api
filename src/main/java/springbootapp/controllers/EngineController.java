package springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Car;
import springbootapp.entities.Engine;
import springbootapp.service.serviceimpl.EngineServiceImpl;

import java.util.Optional;

@RestController
public class EngineController {

    @Autowired
    private EngineServiceImpl engineService;

    @RequestMapping(value = "/api/engine/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Engine>> getEngine(long id) {
        Optional<Engine> engine = engineService.findByID(id);
        if (engine != null) {
            return new ResponseEntity<Optional<Engine>>(engineService.findByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<Engine>>((Optional<Engine>)null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/engine/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateEngine(@RequestBody Long id) {
        try {
            //Optional<Engine> engine = engineService.findByID(id);
            Engine engine = engineService.getByID(id);
            engine.setType("Electric");
            return new ResponseEntity<>(engineService.update(engine), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/engine/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteEngine(@PathVariable long id) {
        try {
            Optional<Engine> engine = engineService.findByID(id);
            engineService.remove(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/engine/create", method = RequestMethod.POST)
    public ResponseEntity<?> createEngine(@RequestBody Engine engine) {
        return new ResponseEntity<>(engineService.save(engine), HttpStatus.CREATED);
    }
}

package springbootapp.controllers;

import com.example.boot.starter.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Car;
import springbootapp.entities.Manual;
import springbootapp.repositories.ManualRepository;
import springbootapp.service.serviceimpl.CarServiceImpl;
import springbootapp.service.serviceimpl.ManualServiceImpl;

import java.util.Optional;

@RestController
public class ManualController {

    @Autowired
    private ManualRepository manualRepository;

    @Autowired
    private ManualServiceImpl manualService;

    @RequestMapping(value = "/api/manual/read/{id}", method = RequestMethod.GET)
    public Optional<Manual> getManual(long id) {
        Optional<Manual> manual = manualService.getByID(id);
        return manual;
    }

    @RequestMapping(value = "/api/manual/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateManual(@RequestBody Manual manual) {
        return new ResponseEntity<>(manualService.update(manual), HttpStatus.UPGRADE_REQUIRED);
    }

    @RequestMapping(value = "/api/manual/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteManual(@PathVariable long id) {
        Optional<Manual> manual = manualService.getByID(id);
        manualService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/manual/create", method = RequestMethod.POST)
    public ResponseEntity<?> createManual(@RequestBody Manual manual) {
        return new ResponseEntity<>(manualService.save(manual), HttpStatus.CREATED);
    }
}

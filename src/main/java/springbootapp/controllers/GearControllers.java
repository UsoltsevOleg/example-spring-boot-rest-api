package springbootapp.controllers;

import com.example.boot.starter.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Car;
import springbootapp.entities.Gear;
import springbootapp.repositories.GearRepository;
import springbootapp.service.GearService;
import springbootapp.service.serviceimpl.CarServiceImpl;
import springbootapp.service.serviceimpl.GearServiceImpl;

import java.util.Optional;

@RestController
public class GearControllers {

    @Autowired
    private GearRepository gearRepository;

    @Autowired
    private GearServiceImpl gearService;

    @RequestMapping(value = "/api/gear/read/{id}", method = RequestMethod.GET)
    public Optional<Gear> getGear(long id) {
        Optional<Gear> gear = GearService.getByID(id);
        return gear;
    }

    @RequestMapping(value = "/api/gear/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateGear(@RequestBody Gear gear) {
        return new ResponseEntity<>(gearService.update(gear), HttpStatus.UPGRADE_REQUIRED);
    }

    @RequestMapping(value = "/api/gear/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteGear(@PathVariable long id) {
        Optional<Gear> gear = gearService.getByID(id);
        gearService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/gear/create", method = RequestMethod.POST)
    public ResponseEntity<?> createGear(@RequestBody Gear gear) {
        return new ResponseEntity<>(gearService.save(gear), HttpStatus.CREATED);
    }
}

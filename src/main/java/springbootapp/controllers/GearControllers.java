package springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Gear;
import springbootapp.service.serviceimpl.GearServiceImpl;

import java.util.Optional;

@RestController
public class GearControllers {

    @Autowired
    private GearServiceImpl gearService;

    @RequestMapping(value = "/api/gear/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Gear>> getGear(long id) {
        Optional<Gear> gear = gearService.getByID(id);
        if (gear != null) {
            return new ResponseEntity<Optional<Gear>>(gearService.getByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<Gear>>((Optional<Gear>) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/gear/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateGear(@RequestBody long id) {
        try {
            //Optional<Gear> gear = gearService.findGear(car);
            Optional<Gear> gear = gearService.getByID(id);
            gear.setGearSize(10);
            return new ResponseEntity<>(gearService.update(gear), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/gear/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteGear(@PathVariable long id) {
        try {
            Optional<Gear> gear = gearService.getByID(id);
            gearService.remove(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/gear/create", method = RequestMethod.POST)
    public ResponseEntity<?> createGear(@RequestBody Gear gear) {
        return new ResponseEntity<>(gearService.save(gear), HttpStatus.CREATED);
    }
}

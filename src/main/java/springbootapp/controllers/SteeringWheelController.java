package springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.SteeringWheel;
import springbootapp.service.serviceimpl.SteeringWheelServiceImpl;

import java.util.Optional;

@RestController
public class SteeringWheelController {

    @Autowired
    private SteeringWheelServiceImpl steeringWheelService;

    @RequestMapping(value = "/api/steeringWheel/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<SteeringWheel>> getSteeringWheelService(long id) {
        Optional<SteeringWheel> steeringWheel = steeringWheelService.getByID(id);
        if (steeringWheel != null) {
            return new ResponseEntity<Optional<SteeringWheel>>(steeringWheelService.getByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<SteeringWheel>>((Optional<SteeringWheel>) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/steeringWheel/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateSteeringWheelService(@RequestBody long id) {
        try {
            Optional<SteeringWheel> steeringWheel = steeringWheelService.getByID(id);
            steeringWheel.setType("Sport");
            return new ResponseEntity<>(steeringWheelService.update(steeringWheel), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/steeringWheel/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSteeringWheelService(@PathVariable long id) {
        try {
            Optional<SteeringWheel> steeringWheel = steeringWheelService.getByID(id);
            steeringWheelService.remove(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/steeringWheel/create", method = RequestMethod.POST)
    public ResponseEntity<?> createSteeringWheelService(@RequestBody SteeringWheel steeringWheel) {
        return new ResponseEntity<>(steeringWheelService.save(steeringWheel), HttpStatus.CREATED);
    }
}

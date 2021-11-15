package springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Manual;
import springbootapp.service.serviceimpl.ManualServiceImpl;

import java.util.Optional;

@RestController
public class ManualController {

    @Autowired
    private ManualServiceImpl manualService;

    @RequestMapping(value = "/api/manual/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Manual>> getManual(long id) {
        Optional<Manual> manual = manualService.findByID(id);
        if (manual != null) {
            return new ResponseEntity<Optional<Manual>>(manualService.findByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<Manual>>((Optional<Manual>) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/manual/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateManual(@RequestBody Long id) {
        try {
            //Optional<Manual> manual = manualService.findByID(id);
            Manual manual = manualService.getByID(id);
            manual.setType("Book");
            return new ResponseEntity<>(manualService.update(manual), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/manual/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteManual(@PathVariable long id) {
        try {
            Optional<Manual> manual = manualService.findByID(id);
            manualService.remove(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/manual/create", method = RequestMethod.POST)
    public ResponseEntity<?> createManual(@RequestBody Manual manual) {
        return new ResponseEntity<>(manualService.save(manual), HttpStatus.CREATED);
    }
}

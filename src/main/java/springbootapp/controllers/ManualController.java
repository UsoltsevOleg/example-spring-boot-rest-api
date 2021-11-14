package springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Manual;
import springbootapp.repositories.ManualRepository;
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
        if (manual != null) {
            return new ResponseEntity<>(manualService.getByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/manual/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateManual(@RequestBody Manual manual) {
        try {
            return new ResponseEntity<>(manualService.update(manual), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/manual/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteManual(@PathVariable long id) {
        try {
            Optional<Manual> manual = manualService.getByID(id);
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

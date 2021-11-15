package springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.entities.Car;
import springbootapp.service.serviceimpl.CarServiceImpl;

import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @RequestMapping(value = "/api/car/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<? extends Object> getCar(long id) {
        Optional<Car> car = carService.findByID(id);
        if (car != null) {
            return new ResponseEntity<Optional<Car>>(carService.findByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<Car>>((Optional<Car>) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/car/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateCar(@RequestBody long id) {
        try {
            //Optional<Car> car = carService.findByID(id);
            Car car = carService.getByID(id);
            car.setManufacturerName("Lada");
            return new ResponseEntity<>(carService.update(car), HttpStatus.UPGRADE_REQUIRED);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/car/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteCar(@PathVariable long id) {
        try {
            Optional<Car> car = carService.findByID(id);
            carService.remove(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("id не найден");
            return null;
        }
    }

    @RequestMapping(value = "/api/car/create", method = RequestMethod.POST)
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }
}



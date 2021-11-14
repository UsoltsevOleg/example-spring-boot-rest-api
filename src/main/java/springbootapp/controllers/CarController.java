package springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapp.repositories.CarRepository;
import springbootapp.service.serviceimpl.CarServiceImpl;
import springbootapp.entities.Car;

import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarServiceImpl carService;

    @RequestMapping(value = "/api/car/read/{id}", method = RequestMethod.GET)
    public Optional<Car> getCar(long id) {
        Optional<Car> car = carService.getByID(id);
        return car;
    }

    @RequestMapping(value = "/api/car/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> updateCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.update(car), HttpStatus.UPGRADE_REQUIRED);
    }

    @RequestMapping(value = "/api/car/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteCar(@PathVariable long id) {
        Optional<Car> car = carService.getByID(id);
        carService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/car/create", method = RequestMethod.POST)
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }
}



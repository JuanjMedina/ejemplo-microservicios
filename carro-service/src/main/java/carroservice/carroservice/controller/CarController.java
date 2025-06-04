package carroservice.carroservice.controller;

import carroservice.carroservice.entities.Car;
import carroservice.carroservice.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable("carId") Long id) {
        Car car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable("userId") Long userId) {
        List<Car> cars = carService.getCarsByUserId(userId);
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @PostMapping()
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        return ResponseEntity.ok(savedCar);
    }




}

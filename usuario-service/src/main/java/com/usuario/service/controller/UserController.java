package com.usuario.service.controller;

import com.usuario.service.entities.User;
import com.usuario.service.models.Car;
import com.usuario.service.models.Motorbike;
import com.usuario.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/car/{userId}")
    public ResponseEntity<List<Car>> getAllCarsByUserId(@PathVariable("userId") Long userId) {
        List<Car> cars = userService.getAllCars(userId);
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/motorbike/{userId}")
    public ResponseEntity<List<Motorbike>> getAllMotorbikesByUserId(@PathVariable("userId") Long userId) {
        List<Motorbike> motorbikes = userService.getAllMotorbikes(userId);
        if (motorbikes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorbikes);
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("/car/{userId}")
    public ResponseEntity<Car> saveCar(@RequestBody Car car, @PathVariable("userId") Long userId) {
        Car savedCar = userService.saveCar(car, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @PostMapping("/motorbike/{userId}")
    public ResponseEntity<Motorbike> saveMotorbike(@RequestBody Motorbike motorbike, @PathVariable("userId") Long userId) {
        Motorbike savedMotorbike = userService.saveMotorbike(motorbike, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMotorbike);
    }


}

package motoservice.motoservice.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import motoservice.motoservice.model.Motorbike;
import motoservice.motoservice.service.MotorbikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorbikes")
@Slf4j
public class MotorbikeController {
    private final MotorbikeService motorbikeService;

    public MotorbikeController(MotorbikeService motorbikeService) {
        this.motorbikeService = motorbikeService;
    }


    @GetMapping
    public ResponseEntity<List<Motorbike>> getAllMotorbikes() {
        List<Motorbike> motorbikes = motorbikeService.getAllMotorbikes();
        return ResponseEntity.ok(motorbikes);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Motorbike>> getMotorbikeByUserId(@PathVariable("userId") Long userId) {
        List<Motorbike> motorbike = motorbikeService.getMotorbikeByUserId(userId);
        if (motorbike != null) {
            return ResponseEntity.ok(motorbike);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{motorbikeId}")
    public ResponseEntity<Motorbike> getMotorbikeById(@PathVariable("motorbikeId") Long motorbikeId) {
        Motorbike motorbike = motorbikeService.getMotorbikeById(motorbikeId);
        return ResponseEntity.ok(motorbike);
    }

    @PostMapping("/create")
    public ResponseEntity<Motorbike> createMotorbike(@RequestBody Motorbike motorbike) {
        Motorbike savedMotorbike = motorbikeService.saveMotorbike(motorbike);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMotorbike);
    }


}

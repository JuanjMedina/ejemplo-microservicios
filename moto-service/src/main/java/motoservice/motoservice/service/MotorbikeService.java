package motoservice.motoservice.service;

import motoservice.motoservice.model.Motorbike;
import motoservice.motoservice.repotories.MotorbikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorbikeService {

    private final MotorbikeRepository motorbikeRepository;

    public MotorbikeService(MotorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }

    public List<Motorbike> getMotorbikeByUserId(Long userId) {
        return motorbikeRepository.findByUserId(userId);
    }

    public Motorbike getMotorbikeById(Long motorbikeId) {
        return motorbikeRepository.findById(motorbikeId).orElseThrow(() -> new IllegalArgumentException("Motorbike with given ID does not exist"));
    }

    public Motorbike saveMotorbike(Motorbike motorbike) {
        return motorbikeRepository.save(motorbike);
    }

    public void deleteMotorbike(Long id) {
        motorbikeRepository.deleteById(id);
    }


    public List<Motorbike> getAllMotorbikes() {
        return motorbikeRepository.findAll();
    }
}

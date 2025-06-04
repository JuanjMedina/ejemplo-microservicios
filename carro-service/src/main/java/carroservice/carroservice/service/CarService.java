package carroservice.carroservice.service;

import carroservice.carroservice.entities.Car;
import carroservice.carroservice.repositories.CarRepositoy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {
    private final CarRepositoy carRepositoy;

    public CarService(CarRepositoy carRepositoy) {
        this.carRepositoy = carRepositoy;
    }

    public List<Car> getCarsByUserId(Long userId) {
        return carRepositoy.findByUserId(userId);
    }

    public Car saveCar(Car car) {
        return carRepositoy.save(car);
    }

    public void deleteCar(Long carId) {
        carRepositoy.deleteById(carId);
    }

    public List<Car> getAllCars() {
        return carRepositoy.findAll();
    }

    public Car getCarById(Long carId) {
        return carRepositoy.findById(carId).orElseThrow(() -> new RuntimeException("Car not found with id: " + carId));
    }
}

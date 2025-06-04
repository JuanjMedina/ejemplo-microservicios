package com.usuario.service.service;

import com.usuario.service.entities.User;
import com.usuario.service.feignclients.CarFeignClient;
import com.usuario.service.feignclients.MotorbikeFeignClient;
import com.usuario.service.models.Car;
import com.usuario.service.models.Motorbike;
import com.usuario.service.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final CarFeignClient carFeignClient;
    private final MotorbikeFeignClient motorbikeFeignClient;

    public UserService(UserRepository userRepository, RestTemplate restTemplate, CarFeignClient carFeignClient, MotorbikeFeignClient motorbikeFeignClient) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.carFeignClient = carFeignClient;
        this.motorbikeFeignClient = motorbikeFeignClient;
    }

    public List<Car> getAllCars(Long userId) {
        List cars = restTemplate.getForObject("http://localhost:8082/cars/user/" + userId, List.class);
        return cars;
    }

    public List<Motorbike> getAllMotorbikes(Long userId) {
        List motorbikes = restTemplate.getForObject("http://localhost:8083/motorbikes/user/" + userId, List.class);
        return motorbikes;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Car saveCar(Car car, Long userId) {
        car.setUserId(userId);
        return carFeignClient.save(car);
    }

    public Motorbike saveMotorbike(Motorbike motorbike, Long userId) {
        motorbike.setUserId(userId);
        return motorbikeFeignClient.save(motorbike);
    }

    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}

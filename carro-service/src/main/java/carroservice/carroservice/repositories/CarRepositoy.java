package carroservice.carroservice.repositories;

import carroservice.carroservice.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepositoy extends JpaRepository<Car, Long> {
    List<Car> findByUserId(Long userId);
}

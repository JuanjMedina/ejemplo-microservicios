package com.usuario.service.feignclients;

import com.usuario.service.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "carro-service", url = "http://localhost:8082")
public interface CarFeignClient {
    @PostMapping("/cars")
    Car save(@RequestBody Car car);
}


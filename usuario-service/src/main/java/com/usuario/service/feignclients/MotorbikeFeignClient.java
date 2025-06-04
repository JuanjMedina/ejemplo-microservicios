package com.usuario.service.feignclients;

import com.usuario.service.models.Motorbike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "motorbike-service", url = "http://localhost:8083")
public interface MotorbikeFeignClient {

    @PostMapping("/motorbikes/create")
    Motorbike save(@RequestBody Motorbike motorbike);

}

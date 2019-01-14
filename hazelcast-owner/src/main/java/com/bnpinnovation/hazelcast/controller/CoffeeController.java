package com.bnpinnovation.hazelcast.controller;

import com.bnpinnovation.hazelcast.domain.Coffee;
import com.bnpinnovation.hazelcast.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping(value = "/coffee", produces = "application/json")
    public Coffee coffee(@RequestParam(value = "key",defaultValue = "1") String key) throws InterruptedException {
        log.info("controller");
        return coffeeService.makeCoffee(key);
    }

}

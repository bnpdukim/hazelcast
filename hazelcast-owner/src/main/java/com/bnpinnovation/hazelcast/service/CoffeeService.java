package com.bnpinnovation.hazelcast.service;

import com.bnpinnovation.hazelcast.domain.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

public interface CoffeeService {

    Coffee makeCoffee(String key) throws InterruptedException;

    @Service
    @Slf4j
    @CacheConfig(cacheNames = "coffee")
    class Default implements CoffeeService {

        @Override
        @Cacheable(key="#id")
        public Coffee makeCoffee(String id) throws InterruptedException {
            Thread.sleep(3000);
            return new Coffee("아메리카노" + id);
        }

        @CacheEvict(allEntries = true)
        public void clearCache(){}
    }
}

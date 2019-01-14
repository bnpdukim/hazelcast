package com.bnpinnovation.hazelcast.service;

import com.bnpinnovation.hazelcast.domain.Coffee;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface CoffeeService {

    Coffee makeCoffee(String key) throws InterruptedException;

    @Service
    @Slf4j
    @CacheConfig(cacheNames = "coffee")
    class Default implements CoffeeService {

        @Autowired
        HazelcastInstance instance;

        @Override
        public Coffee makeCoffee(String id) throws InterruptedException {
            Map<String,Coffee> coffeeMap = instance.getMap("coffee");
            return coffeeMap.get(id);
        }
    }
}

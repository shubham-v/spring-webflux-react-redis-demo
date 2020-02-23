package com.demo.react.redis.controller;

import com.demo.react.redis.entity.Contact;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Slf4j
@RestController
@RequestMapping("/cache")
public class CacheController {

    private static final Logger log = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    @Qualifier("contactOperations")
    private ReactiveRedisOperations contactOperations;

    @GetMapping("/contact")
    public Flux<Contact> getAll() {
        return this.contactOperations.keys("*").flatMap(this.contactOperations.opsForValue()::get);
    }

    @PostMapping("/contact")
    public void cache(@RequestBody Contact contact) {
        log.info("Request Body.... {}", new Gson().toJson(contact));
        Flux.just(contact.getMobiles().stream().toArray(String[]::new))
                .map(m ->
                    contactOperations.opsForValue().set(m, contact)
                ).subscribe();
    }

    @GetMapping("/contact/{mobileNumber:.+}")
    public Mono<Contact> getCache(@PathVariable String mobileNumber) {
        return this.contactOperations.opsForValue().get(mobileNumber);
    }

}

package com.demo.react.redis.config;

import com.demo.react.redis.entity.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class ContactConfiguration {

    @Bean("contactOperations")
    ReactiveRedisOperations<String, Contact> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Contact> serializer = new Jackson2JsonRedisSerializer<>(Contact.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Contact> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, Contact> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

}

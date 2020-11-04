package com.training.ykb.restaurant.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestaurantConfig {

    @Bean
    @LoadBalanced
    public RestTemplate myRestTemplate() {
        return new RestTemplate();
    }

}

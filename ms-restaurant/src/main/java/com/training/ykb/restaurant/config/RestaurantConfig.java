package com.training.ykb.restaurant.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name = "ORDER", configuration = OrderRibbonConfig.class)
public class RestaurantConfig {

    @Bean
    @LoadBalanced
    public RestTemplate myRestTemplate() {
        return new RestTemplate();
    }

}

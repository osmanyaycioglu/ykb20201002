package com.training.ykb.restaurant.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name = "ORDER", configuration = OrderRibbonConfig.class)
@RefreshScope
public class RestaurantConfig {

    @Value("${my.test.config}")
    private String testStr;

    @Bean
    @LoadBalanced
    public RestTemplate myRestTemplate() {
        return new RestTemplate();
    }


    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    public String getTestStr() {
        return this.testStr;
    }


}

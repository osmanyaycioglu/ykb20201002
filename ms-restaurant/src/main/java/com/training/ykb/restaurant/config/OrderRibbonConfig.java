package com.training.ykb.restaurant.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

public class OrderRibbonConfig {

    @Bean
    public IRule myRule() {
        return new BestAvailableRule();
    }

    @Bean
    public IPing myPing() {
        return new NoOpPing();
    }

}

package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.model.RestaurantOrder;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Value("${server.port}")
    private int port;

    @PostMapping("/place")
    public String place(final RestaurantOrder ro) {
        return "OK-" + this.port;
    }

}

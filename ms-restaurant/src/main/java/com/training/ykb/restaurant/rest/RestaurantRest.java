package com.training.ykb.restaurant.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.restaurant.model.RestaurantOrder;
import com.training.ykb.restaurant.service.OrderClientService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantRest {

    @Autowired
    private OrderClientService ocs;

    @PostMapping("/order")
    public String order(@RequestBody final RestaurantOrder ro) {
        return this.ocs.order(ro);
    }

}

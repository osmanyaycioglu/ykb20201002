package com.training.ykb.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.ykb.restaurant.model.RestaurantOrder;

@Service
public class OrderClientService {

    @Autowired
    private RestTemplate rt;

    public String order(final RestaurantOrder ro) {
        return this.rt.postForObject("http://ORDER/order/place",
                                     ro,
                                     String.class);
    }


}

package com.training.ykb.restaurant.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ykb.common.error.MyRestException;
import com.training.ykb.restaurant.model.RestaurantOrder;

@FeignClient("ORDER")
@RequestMapping("/order")
public interface IOrderClient {

    @PostMapping("/place")
    public String place(final RestaurantOrder ro) throws MyRestException;

}

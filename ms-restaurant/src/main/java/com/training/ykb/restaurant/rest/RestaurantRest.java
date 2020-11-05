package com.training.ykb.restaurant.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.common.error.ErrorObject;
import com.training.ykb.common.error.MyRestException;
import com.training.ykb.restaurant.model.RestaurantOrder;
import com.training.ykb.restaurant.service.OrderClientService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantRest {

    @Autowired
    private OrderClientService ocs;

    @PostMapping("/order")
    public String order(@RequestBody final RestaurantOrder ro) throws MyRestException {
        return this.ocs.orderFeign(ro);
    }

    @ExceptionHandler(MyRestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleMyRestException(final MyRestException exceptionParam) {
        return new ErrorObject().setDomain("IT")
                                .setSubdomain("CRM")
                                .setBoundedContext("contract")
                                .setMicroservice("restaurant")
                                .setMessage("error while calling next ms")
                                .setErrorCause(205)
                                .addSubError(exceptionParam.getErrorObject());

    }

}

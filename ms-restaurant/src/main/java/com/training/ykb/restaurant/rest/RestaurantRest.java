package com.training.ykb.restaurant.rest;

import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.common.error.ErrorObject;
import com.training.ykb.common.error.MyRestException;
import com.training.ykb.restaurant.model.Notification;
import com.training.ykb.restaurant.model.RestaurantOrder;
import com.training.ykb.restaurant.service.OrderClientService;

@RestController
@RequestMapping("/restaurant")
@RefreshScope
public class RestaurantRest {

    @Autowired
    private OrderClientService ocs;

    @Autowired
    private RabbitTemplate     rabT;

    @Value("${my.test.config}")
    private String             testStr;

    @PostMapping("/order")
    public String order(@RequestBody final RestaurantOrder ro) throws MyRestException {
        return this.ocs.orderFeign(ro);
    }

    @GetMapping("/test")
    public String test() {
        Notification notificationLoc = new Notification();
        notificationLoc.setMessage("hello world " + (new Random().nextInt()));
        notificationLoc.setNumber("903778236323");
        this.rabT.convertAndSend("notfy_exchange",
                                 "notify_me",
                                 notificationLoc);
        return "OK";
    }

    @GetMapping("/conf")
    public String configTest() {
        return this.testStr;
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

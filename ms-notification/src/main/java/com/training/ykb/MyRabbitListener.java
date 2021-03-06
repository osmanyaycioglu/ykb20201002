package com.training.ykb;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notification_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "notfy_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_me"))
    @SendTo("notfy_response_exchange/notify_response_me")
    public String handleABC(final Notification notificationParam) {
        System.out.println("Incoming : " + notificationParam);
        return "Processed " + notificationParam;

    }

}

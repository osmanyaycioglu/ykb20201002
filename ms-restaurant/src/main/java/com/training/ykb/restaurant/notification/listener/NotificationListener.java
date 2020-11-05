package com.training.ykb.restaurant.notification.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notification_response_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "notfy_response_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_response_me"))
    public void handleABC(final String notificationResponseParam) {
        System.out.println("Notification Response : " + notificationResponseParam);

    }


}

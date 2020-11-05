package com.training.ykb.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ykb.restaurant.model.RestaurantOrder;

@Service
public class OrderClientService {

    @Autowired
    private RestTemplate rt;

    @Autowired
    private EurekaClient client;

    public String order(final RestaurantOrder ro) {
        return this.rt.postForObject("http://ORDER/order/place",
                                     ro,
                                     String.class);
    }

    public String order2(final RestaurantOrder ro) {
        Application applicationLoc = this.client.getApplication("ORDER");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        InstanceInfo current = null;
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            current = instanceInfoLoc;
        }

        current = this.client.getNextServerFromEureka("ORDER",
                                                      false);

        RestTemplate restTemplateLoc = new RestTemplate();
        return restTemplateLoc.postForObject("http://" + current.getIPAddr() + ":" + current.getPort() + "/order/place",
                                             ro,
                                             String.class);
    }

}

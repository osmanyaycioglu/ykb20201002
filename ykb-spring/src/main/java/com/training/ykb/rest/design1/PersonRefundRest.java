package com.training.ykb.rest.design1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.Person;

@RestController
@RequestMapping("/person/refund")
public class PersonRefundRest {

    @PostMapping
    public String refund(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping
    public String refundInfo(@RequestParam("id") final long refundId) {
        return "OK";
    }


}

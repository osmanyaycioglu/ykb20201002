package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @Autowired
    @Qualifier("second")
    private UseSpringBean usb;

    @Autowired
    @Qualifier("third")
    private UseSpringBean thirdUsb;


    @Autowired
    private IProcess pro;

    @GetMapping
    public String hello() {
        this.pro.execute();
        this.usb.xyz();
        this.thirdUsb.xyz();
        return "Hello world";
    }

}

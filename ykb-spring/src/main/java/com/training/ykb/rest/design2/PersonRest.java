package com.training.ykb.rest.design2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.Person;

@RestController
@RequestMapping("/api2/v1/person/provision")
public class PersonRest {

    @PostMapping("/insert")
    public String insert(@RequestBody final Person person) {
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/get")
    public Person select(@RequestParam("personId") final long personId) {
        return null;
    }

    @GetMapping("/delete")
    public Person delete(@RequestParam("personId") final long personId) {
        return null;
    }

}

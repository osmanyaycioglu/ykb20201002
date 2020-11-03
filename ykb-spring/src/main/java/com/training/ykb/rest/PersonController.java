package com.training.ykb.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.Person;


@RestController
@RequestMapping("/per")
public class PersonController {

    @GetMapping("/hello")
    public String hello() {
        return "hello GET";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "hello POST";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "hello PUT";
    }

    @DeleteMapping("/hello")
    public String hello4() {
        return "hello DELETE";
    }

    @PatchMapping("/hello")
    public String hello5() {
        return "hello PATCH";
    }

    @GetMapping("/hello2/{isim}/xyz/{soyisim}")
    public String abc(@PathVariable("isim") final String name,
                      @PathVariable("soyisim") final String surname) {
        return "hello2 " + name + " " + surname;
    }


    @GetMapping("/hello3")
    public String abc2(@RequestParam("isim") final String name,
                       @RequestParam("soyisim") final String surname) {
        return "hello3 " + name + " " + surname;
    }

    @GetMapping("/hello4/{rty}")
    public String abc3(@PathVariable("rty") final String name,
                       @RequestParam("soyisim") final String surname) {
        return "hello4 " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String abc5(@RequestHeader("rty") final String name,
                       @RequestHeader("qwe") final String surname) {
        return "hello5 " + name + " " + surname;
    }


    @PostMapping("/hello6")
    public String abc5(@RequestBody final Person person) {
        return "Hello 6 " + person;
    }

    @PostMapping("/hello7")
    public Person abc7(@RequestBody final Person person) {
        person.setName("ali");
        return person;
    }

    @PostMapping(value = "/hello8",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person abc8(@RequestBody final Person person) {
        person.setName("ali");
        return person;
    }

}


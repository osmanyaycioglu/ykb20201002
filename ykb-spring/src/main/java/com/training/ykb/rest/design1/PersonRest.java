package com.training.ykb.rest.design1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.Person;
import com.training.ykb.services.IPersonProvision;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonRest {

    @Autowired
    private IPersonProvision ipp;

    @PutMapping
    public String insert(@RequestBody final Person person) {
        return this.ipp.add(person);
    }

    @PatchMapping
    public String update(@RequestBody final Person person) {
        return this.ipp.update(person);
    }

    @GetMapping
    public Person select(@RequestParam("personId") final long personId) {
        return this.ipp.search(personId);
    }

    @DeleteMapping
    public String delete(@RequestParam("personId") final long personId) {
        return this.ipp.delete(personId);
    }

    @PostMapping
    public Person post(@RequestParam("personId") final long personId) {
        return null;
    }


}

package com.training.ykb.rest.design1;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class PersonRest {

    @Autowired
    private IPersonProvision ipp;

    @PutMapping
    public String insert(@NotNull @Validated @RequestBody final Person person) {
        int ageLoc = person.getAge();
        if (ageLoc == 30) {
            throw new IllegalArgumentException("Person age doğru değil");
        }
        return this.ipp.add(person);
    }

    @PatchMapping
    public String update(@RequestBody final Person person) {
        return this.ipp.update(person);
    }

    @GetMapping
    public Person select(@Positive @NotNull @RequestParam("personId") final Long personId) {
        return this.ipp.search(personId);
    }

    @DeleteMapping
    public String delete(@RequestParam("personId") final long personId) {
        return this.ipp.delete(personId);
    }

    @PostMapping
    public Person post(@RequestParam("personId") final long personId,
                       final HttpServletRequest rqs) {
        return null;
    }


}

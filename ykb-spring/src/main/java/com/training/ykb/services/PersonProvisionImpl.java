package com.training.ykb.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.training.ykb.Person;

@Service
public class PersonProvisionImpl implements IPersonProvision {

    private final Map<Long, Person> personMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void fillCache() {
        this.personMap.put(1L,
                           new Person(1,
                                      "osman",
                                      "yaycıoğlu",
                                      50,
                                      "Istanbul"));
        this.personMap.put(1L,
                           new Person(2,
                                      "ali",
                                      "kalma",
                                      35,
                                      "Ankara"));
        this.personMap.put(1L,
                           new Person(1,
                                      "ayça",
                                      "arman",
                                      28,
                                      "Bursa"));
    }

    @Override
    public String add(final Person personParam) {
        this.personMap.put(personParam.getPersonId(),
                           personParam);
        return "OK";
    }

    @Override
    public String update(final Person personParam) {
        this.personMap.put(personParam.getPersonId(),
                           personParam);
        return "OK";
    }

    @Override
    public String delete(final long personIdParam) {
        this.personMap.remove(personIdParam);
        return "OK";
    }

    @Override
    public Person search(final long personIdParam) {
        return this.personMap.get(personIdParam);
    }

}

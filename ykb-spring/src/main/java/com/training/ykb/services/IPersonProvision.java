package com.training.ykb.services;

import com.training.ykb.Person;

public interface IPersonProvision {

    public String add(Person personParam);

    public String update(Person personParam);

    public String delete(long personId);

    public Person search(long personId);

}

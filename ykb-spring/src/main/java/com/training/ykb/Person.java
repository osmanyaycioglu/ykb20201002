package com.training.ykb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private long   personId;
    private String name;
    private String surname;
    private int    age;
    private String city;


    public Person() {
    }


    public Person(final long personIdParam,
                  final String nameParam,
                  final String surnameParam,
                  final int ageParam,
                  final String cityParam) {
        super();
        this.personId = personIdParam;
        this.name = nameParam;
        this.surname = surnameParam;
        this.age = ageParam;
        this.city = cityParam;
    }


    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }

    public long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final long personIdParam) {
        this.personId = personIdParam;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }


}

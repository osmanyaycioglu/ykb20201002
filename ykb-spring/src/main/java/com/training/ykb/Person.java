package com.training.ykb;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ykb.validation.StartWith;

@XmlRootElement
public class Person {


    private Long    personId;

    @NotEmpty
    @Size(max = 50, min = 2)
    @StartWith(value = "test", message = "name test ile başlaması gerekiyor")
    private String  name;

    @NotEmpty
    @Size(max = 50, min = 2)
    private String  surname;

    @NotNull
    @Max(value = 150, message = "age 150 den büyük olamaz")
    @Min(18)
    private Integer age;

    @NotEmpty
    @Size(max = 20, min = 2)
    @StartWith("sehir")
    private String  city;


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


    @Override
    public String toString() {
        return "Person [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }


    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }


    public Long getPersonId() {
        return this.personId;
    }


    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }


    public Integer getAge() {
        return this.age;
    }


    public void setAge(final Integer ageParam) {
        this.age = ageParam;
    }


}

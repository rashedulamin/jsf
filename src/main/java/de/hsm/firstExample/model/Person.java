package de.hsm.firstExample.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component(value = "firstExample_person")
@RequestScope
public class Person implements Serializable{
    private String firstName;
    private String lastName;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String save(){
        fullName = firstName + ' '+ lastName;
        return "/firstExample/showPerson.xhtml";
    }

    public Person() {
    }
    
}

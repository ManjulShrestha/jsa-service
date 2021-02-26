package com.am.jsa.common.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedName  {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        if(middleName!=null){
            return firstName + " " + middleName + " " + lastName;
        }
        else{
            return firstName + " " + lastName;
        }
    }
}

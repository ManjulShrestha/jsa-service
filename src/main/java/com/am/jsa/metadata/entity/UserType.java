package com.am.jsa.metadata.entity;


import com.am.jsa.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "USER_TYPE")
public class UserType extends BaseEntity{

    @Column(name = "NAME_ENGLISH")
    private String nameEnglish;

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

}

package com.am.jsa.metadata.entity;


import com.am.jsa.common.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "OFFERED_SALARY_RANGE")
public class OfferedSalaryRange extends BaseEntity {

    @Column(name = "NAME_ENGLISH")
    private String nameEnglish;

    @Column(name = "SORT_ORDER")
    private Integer sortOrder;

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

}

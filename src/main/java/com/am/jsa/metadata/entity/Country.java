package com.am.jsa.metadata.entity;


import com.am.jsa.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table (name = "COUNTRY")
public class Country extends BaseEntity {

    @Column(name = "NAME_ENGLISH")
    private String nameEnglish;

    @Column(name = "iso_a2")
    private String isoA2;

    @Column(name = "iso_a3")
    private String isoA3;

    @Column(name = "iso_n3")
    private String isoN3;

    @Column(name = "nascii_code")
    private Integer nasciiCode;

    @Column(name = "SORT_ORDER")
    private Integer sortOrder;

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getIsoA2() {
        return isoA2;
    }

    public void setIsoA2(String isoA2) {
        this.isoA2 = isoA2;
    }

    public String getIsoA3() {
        return isoA3;
    }

    public void setIsoA3(String isoA3) {
        this.isoA3 = isoA3;
    }

    public String getIsoN3() {
        return isoN3;
    }

    public void setIsoN3(String isoN3) {
        this.isoN3 = isoN3;
    }

    public Integer getNasciiCode() {
        return nasciiCode;
    }

    public void setNasciiCode(Integer nasciiCode) {
        this.nasciiCode = nasciiCode;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

}

package com.am.jsa.company.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
@Table (name = "COMPANY_PICTURES")
public class CompanyPictures extends BaseEntity {

	@Column(name = "PATH")
	private String path;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}

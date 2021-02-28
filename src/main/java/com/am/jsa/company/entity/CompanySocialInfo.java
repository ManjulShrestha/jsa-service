package com.am.jsa.company.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table (name = "COMPANY_SOCIAL_INFO")
public class CompanySocialInfo extends BaseEntity {

	@Column(name = "FACEBOOK")
	private String facebook;

	@Column(name = "TWITTER")
	private String twitter;

	@Column(name = "GOOGLE")
	private String google;

	@Column(name = "LINKEDIN")
	private String linkedIn;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getGoogle() {
		return google;
	}

	public void setGoogle(String google) {
		this.google = google;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}

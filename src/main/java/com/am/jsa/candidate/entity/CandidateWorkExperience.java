package com.am.jsa.candidate.entity;

import com.am.jsa.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table (name = "CANDIDATE_WORK_EXPERIENCE")
public class CandidateWorkExperience extends BaseEntity {

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "PRESENT")
	private boolean present;

	@Column(name = "U_ID")
	private String uuId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESUME_ID")
	private CandidateResume candidateResume;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public void setCandidateResume(CandidateResume candidateResume) {
		this.candidateResume = candidateResume;
	}

}

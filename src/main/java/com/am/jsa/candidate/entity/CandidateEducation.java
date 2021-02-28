package com.am.jsa.candidate.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.metadata.entity.EducationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "CANDIDATE_EDUCATION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandidateEducation extends BaseEntity {

	@Column(name = "TITLE")
	private String title;

	@Column(name = "Institute")
	private String institute;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "U_ID")
	private String uuId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EDUCATION_TYPE_ID")
	private EducationType educationType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESUME_ID")
	private CandidateResume candidateResume;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

	public void setCandidateResume(CandidateResume candidateResume) {
		this.candidateResume = candidateResume;
	}
}

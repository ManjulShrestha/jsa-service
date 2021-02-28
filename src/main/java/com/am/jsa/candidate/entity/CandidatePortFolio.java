package com.am.jsa.candidate.entity;

import com.am.jsa.common.entity.BaseEntity;

import javax.persistence.*;
@Entity
@Table (name = "CANDIDATE_PORTFOLIO")
public class CandidatePortFolio extends BaseEntity {

	@Column(name = "TITLE")
	private String title;

	@Column(name = "PTCTURE_PATH")
	private String picturePath;

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

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
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

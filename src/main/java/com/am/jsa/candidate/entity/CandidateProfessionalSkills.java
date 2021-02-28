package com.am.jsa.candidate.entity;

import com.am.jsa.common.entity.BaseEntity;

import javax.persistence.*;
@Entity
@Table (name = "CANDIDATE_PROFESSIONAL_SKILLS")
public class CandidateProfessionalSkills extends BaseEntity {

	@Column(name = "SKILL_HEADING")
	private String skillHeading;

	@Column(name = "PERCENTAGE")
	private int percentage;

	@Column(name = "U_ID")
	private String uuId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESUME_ID")
	private CandidateResume candidateResume;

	public String getSkillHeading() {
		return skillHeading;
	}

	public void setSkillHeading(String skillHeading) {
		this.skillHeading = skillHeading;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
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

package com.am.jsa.job.entity;

import com.am.jsa.candidate.entity.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@Entity
@Table (name = "JOB_CANDIDATE_APPLICATION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobCandidateApplication{

	@Id
	@Access(AccessType.PROPERTY)
	@Column(name = "JOB_ID")
	private Long jobId;

	@Column(name="CANDIDATE_ID")
	private Long candidateId;

	@Column(name="SHORTLISTED")
	private Boolean shortlisted;

	@Transient
	@JsonProperty
	private Candidate candidate;

	@Transient
	@JsonProperty
	private Job job;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Boolean getShortlisted() {
		return shortlisted;
	}

	public void setShortlisted(Boolean shortlisted) {
		this.shortlisted = shortlisted;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}

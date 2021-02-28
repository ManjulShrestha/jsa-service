package com.am.jsa.candidate.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table (name = "CANDIDATE_RESUME")
public class CandidateResume extends BaseEntity {


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "candidateResume", cascade = { CascadeType.ALL })
	private Set<CandidateEducation> candidateEducations= new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "candidateResume", cascade = { CascadeType.ALL })
	private Set<CandidateAwards> candidateAwards= new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "candidateResume", cascade = { CascadeType.ALL })
	private Set<CandidatePortFolio> candidatePortFolios= new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "candidateResume", cascade = { CascadeType.ALL })
	private Set<CandidateProfessionalSkills> candidateProfessionalSkills= new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "candidateResume", cascade = { CascadeType.ALL })
	private Set<CandidateWorkExperience> candidateWorkExperiences= new HashSet<>();

	@Column(name = "DOC_PATH")
	private String pdfPath;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CANDIDATE_ID")
	private Candidate candidate;

	public Set<CandidateEducation> getCandidateEducations() {
		return candidateEducations;
	}

	public void setCandidateEducations(Set<CandidateEducation> candidateEducations) {
		this.candidateEducations = candidateEducations;
	}

	public Set<CandidateAwards> getCandidateAwards() {
		return candidateAwards;
	}

	public void setCandidateAwards(Set<CandidateAwards> candidateAwards) {
		this.candidateAwards = candidateAwards;
	}

	public Set<CandidatePortFolio> getCandidatePortFolios() {
		return candidatePortFolios;
	}

	public void setCandidatePortFolios(Set<CandidatePortFolio> candidatePortFolios) {
		this.candidatePortFolios = candidatePortFolios;
	}

	public Set<CandidateProfessionalSkills> getCandidateProfessionalSkills() {
		return candidateProfessionalSkills;
	}

	public void setCandidateProfessionalSkills(Set<CandidateProfessionalSkills> candidateProfessionalSkills) {
		this.candidateProfessionalSkills = candidateProfessionalSkills;
	}

	public Set<CandidateWorkExperience> getCandidateWorkExperiences() {
		return candidateWorkExperiences;
	}

	public void setCandidateWorkExperiences(Set<CandidateWorkExperience> candidateWorkExperiences) {
		this.candidateWorkExperiences = candidateWorkExperiences;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}


	public void setReferenceInChildren() {
		if (this.candidateAwards != null) {
			Iterator<CandidateAwards> candidateAwardsIterator = this.candidateAwards.iterator();
			while (candidateAwardsIterator.hasNext()) {
				CandidateAwards candidateAwards = candidateAwardsIterator.next();
				candidateAwards.setCandidateResume(this);
			}
		}

		if (this.candidateEducations != null) {
			Iterator<CandidateEducation> candidateEducationIterator = this.candidateEducations.iterator();
			while (candidateEducationIterator.hasNext()) {
				CandidateEducation candidateEducation = candidateEducationIterator.next();
				candidateEducation.setCandidateResume(this);
			}
		}

		if (this.candidatePortFolios != null) {
			Iterator<CandidatePortFolio> candidatePortFolioIterator = this.candidatePortFolios.iterator();
			while (candidatePortFolioIterator.hasNext()) {
				CandidatePortFolio candidatePortFolio = candidatePortFolioIterator.next();
				candidatePortFolio.setCandidateResume(this);
			}
		}

		if (this.candidateProfessionalSkills != null) {
			Iterator<CandidateProfessionalSkills> candidateProfessionalSkillsIterator = this.candidateProfessionalSkills.iterator();
			while (candidateProfessionalSkillsIterator.hasNext()) {
				CandidateProfessionalSkills candidateProfessionalSkills = candidateProfessionalSkillsIterator.next();
				candidateProfessionalSkills.setCandidateResume(this);
			}
		}
		if (this.candidateWorkExperiences != null) {
			Iterator<CandidateWorkExperience> candidateWorkExperienceIterator = this.candidateWorkExperiences.iterator();
			while (candidateWorkExperienceIterator.hasNext()) {
				CandidateWorkExperience candidateWorkExperience = candidateWorkExperienceIterator.next();
				candidateWorkExperience.setCandidateResume(this);

			}
		}
	}
}

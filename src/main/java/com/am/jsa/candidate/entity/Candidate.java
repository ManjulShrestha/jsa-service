package com.am.jsa.candidate.entity;


import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.identity.entity.User;
import com.am.jsa.job.entity.Job;
import com.am.jsa.metadata.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table (name = "CANDIDATE")
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedEntityGraph(name = "with-resume",
		attributeNodes = {
				@NamedAttributeNode(value = "candidateResume"),
				@NamedAttributeNode(value = "user")
		}
)
public class Candidate extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_TITLE_ID")
	private JobTitle jobTitle;

	@Column(name = "ALLOW_IN_SEARCH")
	private boolean allowInSearch;

	@Column(name = "MINIMUM_SALARY")
	private double minimumSalary;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CURRENCY_ID")
	private Currency currency;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	private Gender gender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EXPERIENCE_RANGE_ID")
	private ExperienceRange experienceRange;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AGE_RANGE_ID")
	private AgeRange ageRange;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EDUCATION_TYPE_ID")
	private EducationType educationType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LANGUAGE_ID")
	private Language language;

	@Column(name = "CURRENT_SALARY_MINIMUM")
	private double currentSalaryMinimum;

	@Column(name = "CURRENT_SALARY_MAXIMUM")
	private double currentSalaryMaximum;

	@Column(name = "EXPECTED_SALARY_MINIMUM")
	private double expectedSalaryMinimum;

	@Column(name = "EXPECTED_SALARY_MAXIMUM")
	private double expectedSalaryMaximum;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "candidate", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private CandidateSocialInfo candidateSocialInfo;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "candidate", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private CandidateContactInfo candidateContactInfo;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "candidate", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private CandidateResume candidateResume;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Category.class)
	@JoinTable(name = "CANDIDATE_CATEGORY", joinColumns=@JoinColumn(name="CANDIDATE_ID"),inverseJoinColumns = @JoinColumn(name="CATEGORY_ID"))
	private Set<Category> categorySet;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DOC_PATH")
	private String picturePath;

	@Column(name = "ACTIVE")
	private Boolean active;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private User user;

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Job.class)
	@JoinTable(name = "CANDIDATE_JOB_FAVOURITE", joinColumns=@JoinColumn(name="CANDIDATE_ID"),inverseJoinColumns = @JoinColumn(name="JOB_ID"))
	private Set<Job> jobFavouriteSet;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="CANDIDATE_JOB_FAVOURITE", joinColumns=@JoinColumn(name="CANDIDATE_ID"))
	@Column(name="JOB_ID")
	public Set<Long> jobFavouriteSetId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public boolean isAllowInSearch() {
		return allowInSearch;
	}

	public void setAllowInSearch(boolean allowInSearch) {
		this.allowInSearch = allowInSearch;
	}

	public double getMinimumSalary() {
		return minimumSalary;
	}

	public void setMinimumSalary(double minimumSalary) {
		this.minimumSalary = minimumSalary;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public ExperienceRange getExperienceRange() {
		return experienceRange;
	}

	public void setExperienceRange(ExperienceRange experienceRange) {
		this.experienceRange = experienceRange;
	}

	public AgeRange getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(AgeRange ageRange) {
		this.ageRange = ageRange;
	}

	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public double getCurrentSalaryMinimum() {
		return currentSalaryMinimum;
	}

	public void setCurrentSalaryMinimum(double currentSalaryMinimum) {
		this.currentSalaryMinimum = currentSalaryMinimum;
	}

	public double getCurrentSalaryMaximum() {
		return currentSalaryMaximum;
	}

	public void setCurrentSalaryMaximum(double currentSalaryMaximum) {
		this.currentSalaryMaximum = currentSalaryMaximum;
	}

	public double getExpectedSalaryMinimum() {
		return expectedSalaryMinimum;
	}

	public void setExpectedSalaryMinimum(double expectedSalaryMinimum) {
		this.expectedSalaryMinimum = expectedSalaryMinimum;
	}

	public double getExpectedSalaryMaximum() {
		return expectedSalaryMaximum;
	}

	public void setExpectedSalaryMaximum(double expectedSalaryMaximum) {
		this.expectedSalaryMaximum = expectedSalaryMaximum;
	}

	public CandidateSocialInfo getCandidateSocialInfo() {
		return candidateSocialInfo;
	}

	public void setCandidateSocialInfo(CandidateSocialInfo candidateSocialInfo) {
		this.candidateSocialInfo = candidateSocialInfo;
	}

	public CandidateContactInfo getCandidateContactInfo() {
		return candidateContactInfo;
	}

	public void setCandidateContactInfo(CandidateContactInfo candidateContactInfo) {
		this.candidateContactInfo = candidateContactInfo;
	}

	/*public CandidateResume getCandidateResume() {
		return candidateResume;
	}
*/
	public void setCandidateResume(CandidateResume candidateResume) {
		this.candidateResume = candidateResume;
	}

	public Set<Category> getCategorySet() {
		return categorySet;
	}

	public void setCategorySet(Set<Category> categorySet) {
		this.categorySet = categorySet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Long> getJobFavouriteSetId() {
		return jobFavouriteSetId;
	}

	public void setJobFavouriteSetId(Set<Long> jobFavouriteSetId) {
		this.jobFavouriteSetId = jobFavouriteSetId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public void setReferenceInChildren() {
		if(candidateContactInfo!=null){
			candidateContactInfo.setCandidate(this);
		}
		if(candidateSocialInfo!=null){
			candidateSocialInfo.setCandidate(this);
		}
		if(candidateResume!=null){
			candidateResume.setCandidate(this);
			candidateResume.setReferenceInChildren();
		}
	}
}

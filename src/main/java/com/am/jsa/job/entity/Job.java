package com.am.jsa.job.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.company.entity.Company;
import com.am.jsa.metadata.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Table (name = "JOB")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job extends BaseEntity {

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "APPLICATION_DEADLINE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date applicationDeadline;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "COMPLETE_ADDRESS")
	private String completeAddress;

	@Column(name = "MAP_DETAIL")
	private String mapDetail;

	@Column(name = "LONGITUDE")
	private Double longitude;

	@Column(name = "LATITUDE")
	private Double latitude;

	@Column(name = "SLOTS")
	private int slots;

	@Column(name = "VIEWED")
	private int viewed;

	@Column(name = "APPLIED")
	private int applied;

	@Column(name= "FEATURED")
	private boolean featured;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY_ID")
	private City city;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Skill.class)
	@JoinTable(name = "JOB_SKILL", joinColumns=@JoinColumn(name="JOB_ID"),inverseJoinColumns = @JoinColumn(name="SKILL_ID"))
	private Set<Skill> skillSet;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="JOB_CANDIDATE_APPLICATION", joinColumns=@JoinColumn(name="JOB_ID"))
	@Column(name="CANDIDATE_ID")
	public Set<Long> candidateApplicationSetId;


	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="JOB_CANDIDATE_VIEW", joinColumns=@JoinColumn(name="JOB_ID"))
	@Column(name="CANDIDATE_ID")
	public Set<Long> candidateViewSetId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUALIFICATION_ID")
	private Qualification qualification;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INDUSTRY_ID")
	private Industry industry;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	private Gender gender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EXPERIENCE_RANGE_ID")
	private ExperienceRange experienceRange;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CAREER_LEVEL_ID")
	private CareerLevel careerLevel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OFFERERD_SALARY_ID")
	private OfferedSalaryRange offeredSalaryRange;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_TYPE_ID")
	private JobType jobType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_TITLE_ID")
	private JobTitle jobTitle;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@Column(name = "ACTIVE")
	private Boolean active;

    @Column(name = "DOC_PATH")
    private String picturePath;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public String getMapDetail() {
		return mapDetail;
	}

	public void setMapDetail(String mapDetail) {
		this.mapDetail = mapDetail;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Skill> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ExperienceRange getExperienceRange() {
		return experienceRange;
	}

	public void setExperienceRange(ExperienceRange experienceRange) {
		this.experienceRange = experienceRange;
	}

	public CareerLevel getCareerLevel() {
		return careerLevel;
	}

	public void setCareerLevel(CareerLevel careerLevel) {
		this.careerLevel = careerLevel;
	}

	public OfferedSalaryRange getOfferedSalaryRange() {
		return offeredSalaryRange;
	}

	public void setOfferedSalaryRange(OfferedSalaryRange offeredSalaryRange) {
		this.offeredSalaryRange = offeredSalaryRange;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	@JsonIgnore
    public Company getCompany() {
        return company;
    }

    @JsonProperty
	public void setCompany(Company company) {
		this.company = company;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public int getViewed() {
		return viewed;
	}

	public void setViewed(int viewed) {
		this.viewed = viewed;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public int getApplied() {
		return applied;
	}

	public void setApplied(int applied) {
		this.applied = applied;
	}

	public Set<Long> getCandidateApplicationSetId() {
		return candidateApplicationSetId;
	}

	public void setCandidateApplicationSetId(Set<Long> candidateApplicationSetId) {
		this.candidateApplicationSetId = candidateApplicationSetId;
	}

	public Set<Long> getCandidateViewSetId() {
		return candidateViewSetId;
	}

	public void setCandidateViewSetId(Set<Long> candidateViewSetId) {
		this.candidateViewSetId = candidateViewSetId;
	}

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

}

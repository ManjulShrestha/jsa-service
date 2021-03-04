package com.am.jsa.company.entity;

import com.am.jsa.candidate.entity.Candidate;
import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.identity.entity.User;
import com.am.jsa.job.entity.Job;
import com.am.jsa.metadata.entity.Category;
import com.am.jsa.metadata.entity.Industry;
import com.am.jsa.metadata.entity.TeamSize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table (name = "COMPANY")
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedEntityGraph(name = "withJob",
		attributeNodes = {
			@NamedAttributeNode(value = "jobSet"),
			@NamedAttributeNode(value = "user"),
			@NamedAttributeNode(value = "candidateViewSetId"),
			@NamedAttributeNode(value = "candidateFollowSetId")
		})
public class Company extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_SIZE_ID")
	private TeamSize teamSize;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INDUSTRY_ID")
	private Industry industry;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "company", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private CompanySocialInfo companySocialInfo;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "company", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private CompanyContactInfo companyContactInfo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CompanyPictures> companyPictures = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CompanyPayments> companyPayments = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Job> jobSet = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Category.class)
	@JoinTable(name = "COMPANY_CATEGORY", joinColumns=@JoinColumn(name="COMPANY_ID"),inverseJoinColumns = @JoinColumn(name="CATEGORY_ID"))
	private Set<Category> categorySet;

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Candidate.class)
	@JoinTable(name = "COMPANY_CANDIDATE_FOLLOW", joinColumns=@JoinColumn(name="COMPANY_ID"),inverseJoinColumns = @JoinColumn(name="CANDIDATE_ID"))
	private Set<Candidate> candidateFollowSet;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="COMPANY_CANDIDATE_FOLLOW", joinColumns=@JoinColumn(name="COMPANY_ID"))
	@Column(name="CANDIDATE_ID")
	public Set<Long> candidateFollowSetId;


	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Candidate.class)
	@JoinTable(name = "COMPANY_CANDIDATE_VIEW", joinColumns=@JoinColumn(name="COMPANY_ID"),inverseJoinColumns = @JoinColumn(name="CANDIDATE_ID"))
	private Set<Candidate> candidateViewSet;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="COMPANY_CANDIDATE_VIEW", joinColumns=@JoinColumn(name="COMPANY_ID"))
	@Column(name="CANDIDATE_ID")
	public Set<Long> candidateViewSetId;

	@Column(name = "DOC_PATH")
	private String picturePath;

	@Column(name = "FOLLOWERS")
	private int followers;

	@Column(name = "VIEWERS")
	private int viewers;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private User user;

	@Transient
	private Long jobCount;

	@Transient
	private CompanyPayments latestPayment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public TeamSize getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(TeamSize teamSize) {
		this.teamSize = teamSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CompanySocialInfo getCompanySocialInfo() {
		return companySocialInfo;
	}

	public void setCompanySocialInfo(CompanySocialInfo companySocialInfo) {
		this.companySocialInfo = companySocialInfo;
	}

	public CompanyContactInfo getCompanyContactInfo() {
		return companyContactInfo;
	}

	public void setCompanyContactInfo(CompanyContactInfo companyContactInfo) {
		this.companyContactInfo = companyContactInfo;
	}

	public Set<CompanyPayments> getCompanyPayments() {
		return companyPayments;
	}

	public void setCompanyPayments(Set<CompanyPayments> companyPayments) {
		this.companyPayments = companyPayments;
	}

	public Set<Category> getCategorySet() {
		return categorySet;
	}

	public void setCategorySet(Set<Category> categorySet) {
		this.categorySet = categorySet;
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

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Set<Job> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<Job> jobSet) {
		this.jobSet = jobSet;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public Set<Long> getCandidateFollowSetId() {
		return candidateFollowSetId;
	}

	public void setCandidateFollowSetId(Set<Long> candidateFollowSetId) {
		this.candidateFollowSetId = candidateFollowSetId;
	}

	public Set<Long> getCandidateViewSetId() {
		return candidateViewSetId;
	}

	public void setCandidateViewSetId(Set<Long> candidateViewSetId) {
		this.candidateViewSetId = candidateViewSetId;
	}

	public int getViewers() {
		return viewers;
	}

	public void setViewers(int viewers) {
		this.viewers = viewers;
	}

	@JsonProperty
	public Long getJobCount() {
		return jobCount;
	}

	public void setJobCount(Long jobCount) {
		this.jobCount = jobCount;
	}

	@JsonProperty
	public CompanyPayments getLatestPayment() {
		return latestPayment;
	}

	public void setLatestPayment(CompanyPayments latestPayment) {
		this.latestPayment = latestPayment;
	}

	public Set<CompanyPictures> getCompanyPictures() {
		return companyPictures;
	}

	public void setCompanyPictures(Set<CompanyPictures> companyPictures) {
		this.companyPictures = companyPictures;
	}


	public void setReferenceInChildren() {
		if(companyContactInfo!=null){
			companyContactInfo.setCompany(this);
		}
		if(companySocialInfo!=null){
			companySocialInfo.setCompany(this);
		}

		if (this.companyPayments != null) {
			Iterator<CompanyPayments> companyPaymentIterator = this.companyPayments.iterator();
			while (companyPaymentIterator.hasNext()) {
				CompanyPayments companyPayments = companyPaymentIterator.next();
				companyPayments.setCompany(this);
				companyPayments.setReferenceInChildren();
			}
		}

		if (this.companyPictures != null) {
			Iterator<CompanyPictures> companyPicturesIterator = this.companyPictures.iterator();
			while (companyPicturesIterator.hasNext()) {
				CompanyPictures companyPictures = companyPicturesIterator.next();
				companyPictures.setCompany(this);
			}
		}

		if (this.jobSet != null) {
			Iterator<Job> jobIterator = this.jobSet.iterator();
			while (jobIterator.hasNext()) {
				Job job = jobIterator.next();
				job.setCompany(this);
			}
		}

	}
}

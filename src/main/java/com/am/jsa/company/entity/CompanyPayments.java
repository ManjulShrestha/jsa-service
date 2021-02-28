package com.am.jsa.company.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.metadata.entity.MembershipType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "COMPANY_PAYMENTS")
public class CompanyPayments extends BaseEntity {

	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "NO_OF_JOB_SLOTS")
	private int noOfJobSlots;

	@Column(name = "NO_OF_JOB_POSTED")
	private int noOfJobPosted;

	@Column(name = "PAYMENT_AMOUNT")
	private double paymentAmount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MEMBERSHIP_TYPE_ID")
	private MembershipType membershipType;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "companyPayments", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private PaymentDetail paymentDetail;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

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

	public int getNoOfJobSlots() {
		return noOfJobSlots;
	}

	public void setNoOfJobSlots(int noOfJobSlots) {
		this.noOfJobSlots = noOfJobSlots;
	}

	public int getNoOfJobPosted() {
		return noOfJobPosted;
	}

	public void setNoOfJobPosted(int noOfJobPosted) {
		this.noOfJobPosted = noOfJobPosted;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public MembershipType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	@JsonIgnore
	public Company getCompany() {
		return company;
	}

	@JsonProperty
	public void setCompany(Company company) {
		this.company = company;
	}


	public void setReferenceInChildren() {
		if(paymentDetail!=null){
			paymentDetail.setCompanyPayments(this);
			paymentDetail.setReferenceInChildren();
		}

	}
}

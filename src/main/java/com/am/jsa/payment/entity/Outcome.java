package com.am.jsa.payment.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.company.entity.PaymentDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table (name = "PAYMENT_OUTCOME")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Outcome extends BaseEntity {

	@Column(name = "NETWORK_STATUS")
	private String networkStatus;

	@Column(name = "REASON")
	private String reason;

	@Column(name = "SELLER_MESSAGE")
	private String sellerMessage;

	@Column(name = "TYPE")
	private String type;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_DETAIL_ID")
	private PaymentDetail paymentDetail;

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSellerMessage() {
		return sellerMessage;
	}

	public void setSellerMessage(String sellerMessage) {
		this.sellerMessage = sellerMessage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

}

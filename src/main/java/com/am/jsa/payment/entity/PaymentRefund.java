package com.am.jsa.payment.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.company.entity.PaymentDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table (name = "PAYMENT_REFUND")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRefund extends BaseEntity {

	@Column(name = "TOTAL_COUNT")
	private int totalCount;

	@Column(name = "HAS_MORE")
	private boolean hasMore;

	@Column(name = "URL")
	private String url;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_DETAIL_ID")
	private PaymentDetail paymentDetail;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

}

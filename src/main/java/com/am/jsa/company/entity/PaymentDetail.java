package com.am.jsa.company.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.metadata.entity.Currency;
import com.am.jsa.metadata.entity.MerchantType;
import com.am.jsa.payment.entity.Outcome;
import com.am.jsa.payment.entity.PaymentRefund;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table (name = "PAYMENT_DETAIL")
public class PaymentDetail extends BaseEntity {

	@Column(name = "PAYMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MERCHANT_TYPE_ID")
	private MerchantType merchantType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CURRENCY_ID")
	private Currency currency;

	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;

	@Column(name = "TOKEN")
	private String token;

	@Column(name = "CHARGE_ID")
	private String chargeId;

	@Column(name = "PAYMENT_RECEIVED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentReceivedDate;

	@Column(name = "AMOUNT")
	private Double amount;

	@JoinColumn(name = "DESCRIPTION")
	private String description;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "paymentDetail", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Outcome outcome;

	@Column(name = "REFUNDED")
	private boolean refunded;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "paymentDetail", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<PaymentRefund> paymentRefundsSet = new HashSet<>();

	@Column(name = "CARD")
	private String card;

	@Column(name = "STATUS")
	private String status;


	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_PAYMENTS_ID")
	private CompanyPayments companyPayments;

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public MerchantType getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public Date getPaymentReceivedDate() {
		return paymentReceivedDate;
	}

	public void setPaymentReceivedDate(Date paymentReceivedDate) {
		this.paymentReceivedDate = paymentReceivedDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public boolean isRefunded() {
		return refunded;
	}

	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}

	public Set<PaymentRefund> getPaymentRefundsSet() {
		return paymentRefundsSet;
	}

	public void setPaymentRefundsSet(Set<PaymentRefund> paymentRefundsSet) {
		this.paymentRefundsSet = paymentRefundsSet;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setCompanyPayments(CompanyPayments companyPayments) {
		this.companyPayments = companyPayments;
	}


	public void setReferenceInChildren() {
		if (this.outcome != null) {
			this.outcome.setPaymentDetail(this);

		}
		if (this.paymentRefundsSet != null) {
			Iterator<PaymentRefund> refundIterator = this.paymentRefundsSet.iterator();
			while (refundIterator.hasNext()) {
				PaymentRefund paymentRefund = refundIterator.next();
				paymentRefund.setPaymentDetail(this);
			}
		}
	}
}

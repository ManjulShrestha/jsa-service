package com.am.jsa.payment;


import com.am.jsa.company.entity.PaymentDetail;

public interface PaymentService {


    public PaymentDetail chargeCreditCard(PaymentDetail paymentDetail);

}

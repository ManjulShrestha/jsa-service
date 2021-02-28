package com.am.jsa.payment;

import com.am.jsa.company.entity.PaymentDetail;
import com.am.jsa.payment.entity.Outcome;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentServiceImpl {

    private static final String TEST_STRIPE_SECRET_KEY = "sk_test_nu5sMXPDhZGaVIlSQyEMQeMs0020127zp9";
    public PaymentDetail chargeCreditCard(PaymentDetail paymentDetail) {
        Stripe.apiKey = TEST_STRIPE_SECRET_KEY;

        // Stripe requires the charge amount to be in cents
        Double chargeAmountCentsD =  (paymentDetail.getAmount() * 100);
        int chargeAmountCents=chargeAmountCentsD.intValue();

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", chargeAmountCents);
        //chargeParams.put("currency", paymentDetail.getCurrency().getNameEnglish());
        chargeParams.put("currency", "usd");
        chargeParams.put("description", paymentDetail.getDescription());
        chargeParams.put("source",paymentDetail.getToken());

        try {
            // Submit charge to credit card
            Charge charge = Charge.create(chargeParams);
            System.out.println("Charge--"+charge);
            paymentDetail.setChargeId(charge.getId());
            Outcome outcome=new Outcome();
            outcome.setNetworkStatus(charge.getOutcome().getNetworkStatus());
            outcome.setReason(charge.getOutcome().getReason());
            outcome.setSellerMessage(charge.getOutcome().getSellerMessage());
            outcome.setType(charge.getOutcome().getType());
            paymentDetail.setOutcome(outcome);
            paymentDetail.setRefunded(charge.getRefunded());
            //paymentDetail.setPaymentRefundsSet(charge.getRefunds());
            paymentDetail.setPaymentReceivedDate(new Date(charge.getCreated()));
            paymentDetail.setStatus(charge.getStatus());

        } catch (CardException e) {
            // Transaction was declined
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getMessage());
        } catch (RateLimitException e) {
            e.printStackTrace();
            // Too many requests made to the API too quickly
        } catch (InvalidRequestException e) {
            e.printStackTrace();
            // Invalid parameters were supplied to Stripe's API
        } catch (AuthenticationException e) {
            e.printStackTrace();
            // Authentication with Stripe's API failed (wrong API key?)
        } catch (APIConnectionException e) {
            e.printStackTrace();
            // Network communication with Stripe failed
        } catch (StripeException e) {
            // Generic error
            e.printStackTrace();
        } catch (Exception e) {
            // Something else happened unrelated to Stripe
            e.printStackTrace();
        }
        return paymentDetail;
    }
}

package com.assignment.question;

import com.assignment.question.external.AutoProtectApi;
import com.assignment.question.external.AutoProtectStatus;

// The AutoProtectAdapter class is an adapter for the AutoProtectApi.
public class AutoProtectAdapter implements TravelInsuranceAdapter {

    private AutoProtectApi autoProtectApi = new AutoProtectApi(); // An instance of the adaptee class

    // The add method calls the addClaim method of the AutoProtectApi.
    @Override
    public void add(String reference, Double amount) {
        autoProtectApi.addClaim(amount);
    }

    // The get method calls the getStatus method of the AutoProtectApi and converts the AutoProtectStatus to a ClaimStatus.
    @Override
    public ClaimStatus get(String reference) {
        AutoProtectStatus status = autoProtectApi.getStatus(reference);
        if (status == AutoProtectStatus.APPROVED) {
            return ClaimStatus.APPROVED;
        }
        return ClaimStatus.PENDING;
    }
}

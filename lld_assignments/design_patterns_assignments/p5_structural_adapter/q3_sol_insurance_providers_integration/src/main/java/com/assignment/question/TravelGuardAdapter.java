package com.assignment.question;

import com.assignment.question.external.TravelGuardApi;

// The TravelGuardAdapter class is an adapter for the TravelGuardApi.
public class TravelGuardAdapter implements TravelInsuranceAdapter {

    private TravelGuardApi travelGuardApi = new TravelGuardApi(); // An instance of the adaptee class

    // The add method calls the submitClaim method of the TravelGuardApi.
    @Override
    public void add(String reference, Double amount) {
        travelGuardApi.submitClaim(reference, amount);
    }

    // The get method calls the getClaimStatus method of the TravelGuardApi and converts the status to a ClaimStatus.
    @Override
    public ClaimStatus get(String reference) {
        String status = travelGuardApi.getClaimStatus(reference);
        if (status.equals("APPROVED")) {
            return ClaimStatus.APPROVED;
        }
        return ClaimStatus.PENDING;
    }
}

/*
    In this code, the TravelInsuranceAdapter interface defines operations that all concrete
    travel insurance adapters must implement. The AutoProtectAdapter and TravelGuardAdapter
    classes are adapters for the AutoProtectApi and TravelGuardApi classes, respectively.
    They implement the TravelInsuranceAdapter interface and adapt the interfaces of the AutoProtectApi
    and TravelGuardApi classes to the TravelInsuranceAdapter interface.

    This is a classic implementation of the Adapter Pattern. The Adapter Pattern is a
    structural design pattern that allows objects to collaborate that couldn’t otherwise
    because of incompatible interfaces.
 */
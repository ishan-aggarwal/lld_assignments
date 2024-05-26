package com.assignment.question;

// The TravelInsuranceAdapter interface defines operations that all
// concrete travel insurance adapters must implement.
public interface TravelInsuranceAdapter {
    void add(String reference, Double amount);

    ClaimStatus get(String reference);
}

package com.assignment.question;

import com.assignment.question.models.BookingConfirmation;
import com.assignment.question.models.BookingResult;
import com.assignment.question.models.PaymentStatus;
import com.assignment.question.services.*;

import java.time.LocalDate;

public class BookingFacade {

    private final AvailabilityService availabilityService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;
    private final LoyaltyService loyaltyService;
    private final AccommodationDetailsService accommodationDetailsService;

    public BookingFacade(AvailabilityService availabilityService, PaymentService paymentService,
                         NotificationService notificationService, LoyaltyService loyaltyService,
                         AccommodationDetailsService accommodationDetailsService) {
        this.availabilityService = availabilityService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.loyaltyService = loyaltyService;
        this.accommodationDetailsService = accommodationDetailsService;
    }

//    // The process method provides a simplified interface for booking accommodation.
//    public BookingResult book(String userId, String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
//
//        // Check availability of the accommodation
//        boolean isAvailable = checkAvailability(accommodationId, checkInDate, checkOutDate);
//        if (!isAvailable) {
//            return BookingResult.notAvailable("Accommodation not available for the given dates");
//        }
//
//        // Make payment for the booking
//        PaymentStatus paymentStatus = makePayment(userId, accommodationId);
//        if (paymentStatus != PaymentStatus.SUCCESS) {
//            return BookingResult.paymentFailed("Payment failed with status: " + paymentStatus);
//        }
//
//        // Create a booking confirmation
//        BookingConfirmation confirmation = new BookingConfirmation(userId, accommodationId, checkInDate, checkOutDate);
//
//        // Send booking confirmation
//        sendBookingConfirmation(confirmation);
//
//        // Update loyalty points
//        updateLoyaltyPoints(userId, calculatePaymentAmount(accommodationId));
//
//        // Update accommodation details
//        updateAccommodationDetails(accommodationId, checkInDate, checkOutDate);
//
//        // Return the booking result
//        return BookingResult.success(confirmation);
//    }

    public boolean checkAvailability(String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
        return availabilityService.checkAvailability(accommodationId, checkInDate, checkOutDate);
    }

    public PaymentStatus makePayment(String userId, String accommodationId) {
        return paymentService.makePayment(userId, accommodationId);
    }

    public void sendBookingConfirmation(BookingConfirmation confirmation) {
        notificationService.sendBookingConfirmation(confirmation);
    }

    public void updateAccommodationDetails(String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
        accommodationDetailsService.updateAccommodationDetails(accommodationId, checkInDate, checkOutDate);
    }

    public double calculatePaymentAmount(String accommodationId) {
        return paymentService.calculatePaymentAmount(accommodationId);
    }

    public void updateLoyaltyPoints(String x, double y) {
        loyaltyService.updateLoyaltyPoints(x, y);
    }
}

/*
    In this code, the BookingFacade class acts as a facade for various services involved
    in processing a booking. It provides a simplified method book for booking accommodation.
    Also, it provides wrapper methods for the availability of the accommodation,
    makes payment for the booking,
    sends a booking confirmation,
    updates loyalty points, and updates accommodation details.
    The BookingManager class uses the BookingFacade facade to book accommodation.

    This is a classic implementation of the Facade Pattern.
    The Facade Pattern provides a simplified interface to a complex subsystem.
    It defines a higher-level interface that makes the subsystem easier to use
    by wrapping complex subsystem operations into simple methods.
 */
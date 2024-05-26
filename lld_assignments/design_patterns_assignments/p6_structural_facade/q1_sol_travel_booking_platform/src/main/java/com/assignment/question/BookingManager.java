package com.assignment.question;

import com.assignment.question.models.BookingConfirmation;
import com.assignment.question.models.BookingResult;
import com.assignment.question.models.PaymentStatus;
import com.assignment.question.services.*;

import java.time.LocalDate;

public class BookingManager {
    private final BookingFacade bookingFacade;

    public BookingManager(AvailabilityService availabilityService, PaymentService paymentService,
                          NotificationService notificationService, LoyaltyService loyaltyService,
                          AccommodationDetailsService accommodationDetailsService) {

        this.bookingFacade = new BookingFacade(availabilityService,
                paymentService,
                notificationService,
                loyaltyService,
                accommodationDetailsService);
    }

    public BookingResult bookAccommodation(String userId, String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {

        boolean isAvailable = bookingFacade.checkAvailability(accommodationId, checkInDate, checkOutDate);

        if (!isAvailable) {
            return BookingResult.notAvailable("Accommodation not available for the given dates");
        }

        PaymentStatus paymentStatus = bookingFacade.makePayment(userId, accommodationId);
        if (paymentStatus != PaymentStatus.SUCCESS) {
            return BookingResult.paymentFailed("Payment failed with status: " + paymentStatus);
        }

        BookingConfirmation confirmation = new BookingConfirmation(userId, accommodationId, checkInDate, checkOutDate);
        bookingFacade.sendBookingConfirmation(confirmation);

        bookingFacade.updateLoyaltyPoints(userId, bookingFacade.calculatePaymentAmount(accommodationId));
        bookingFacade.updateAccommodationDetails(accommodationId, checkInDate, checkOutDate);

        return BookingResult.success(confirmation);
    }
}
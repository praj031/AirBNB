package com.project.AirBNB.AirBNB.service;

import com.project.AirBNB.AirBNB.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);

}

package org.example;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Represent each call record.
 */
public class Call {
    private final LocalDateTime startCall;
    private final Duration callTime;
    private final double price;

    public LocalDateTime getStartCall() {
        return startCall;
    }

    public Duration getCallTime() {
        return callTime;
    }

    public double getPrice() {
        return price;
    }

    public Call(LocalDateTime startCall, Duration callTime) {
        this.startCall = startCall;
        this.callTime = callTime;
        this.price = setPrice(this.startCall, this.callTime);
    }

    /**
     * Check if this call suitable of 50% promotion.
     * @param startCall call's start time.
     * @return true if before 8:00 or after 18:00.
     */
    public static boolean IsOutside(LocalDateTime startCall) {
        LocalTime startTime = startCall.toLocalTime();
        LocalTime beforeTime = LocalTime.of(8, 0, 0, 0);
        LocalTime afterTime = LocalTime.of(17, 59, 59, 999999999);

        return startTime.isBefore(beforeTime) || startTime.isAfter(afterTime);
    }

    /**
     * Check if time of call is suitable of 15% promotion.
     * @param callTime Time of call.
     * @return true if time of call is over 60 minutes.
     */
    public static boolean IsOver(Duration callTime) {
        return callTime.toSeconds() > 3601;
    }

    private static double Round(double num) {
        return Math.ceil(num * 100) / 100;
    }

    /**
     * Price's calculator.
     * @param startCall call's start time.
     * @param callTime Time of call.
     * @return total price of the call.
     */
    public static double setPrice(LocalDateTime startCall, Duration callTime) {
        double totalPrice = callTime.toSeconds() * 0.5 / 60;

        if(IsOutside(startCall)) totalPrice -= totalPrice * 50 / 100;
        if(IsOver(callTime)) totalPrice -= totalPrice * 15 / 100;

        totalPrice += totalPrice * 5 / 100;

        return Round(totalPrice);
    }


}

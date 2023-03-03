package org.example;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Represent each call record.
 */
public class Call {
    private final LocalTime startCall;
    private final Duration callTime;
    private final double price;

    public LocalTime getStartCall() {
        return startCall;
    }

    public Duration getCallTime() {
        return callTime;
    }

    public double getPrice() {
        if(this.callTime.isNegative()) {
            throw new IllegalArgumentException("Illegal Duration");
        }

        return price;
    }

    public Call(LocalTime startCall, Duration callTime) {
        this.startCall = startCall;
        this.callTime = callTime;
        this.price = setPrice(this.startCall, this.callTime);
    }

    /**
     * Check if this call suitable of 50% promotion.
     * @param startCall call's start time.
     * @return true if before 8:00 or after 18:00.
     */
    public static boolean isOutside(LocalTime startCall) {
        LocalTime beforeTime = LocalTime.of(8, 0, 0, 0);
        LocalTime afterTime = LocalTime.of(17, 59, 59, 999999999);

        return startCall.isBefore(beforeTime) || startCall.isAfter(afterTime);
    }

    /**
     * Check if time of call is suitable of 15% promotion.
     * @param callTime Time of call.
     * @return true if time of call is over 60 minutes.
     */
    public static boolean isOver(Duration callTime) {
        return callTime.toSeconds() > 3601;
    }

    private static double round(double num) {
        return Math.ceil(num * 100) / 100;
    }

    /**
     * Price's calculator.
     * @param startCall call's start time.
     * @param callTime Time of call.
     * @return total price of the call.
     */
    public static double setPrice(LocalTime startCall, Duration callTime) {
        double totalPrice = (int) Math.ceil((double) callTime.toSeconds() / 60) * 0.5;

        if(isOutside(startCall)) totalPrice -= totalPrice * 50 / 100;
        if(isOver(callTime)) totalPrice -= totalPrice * 15 / 100;

        totalPrice += totalPrice * 5 / 100;

        return round(totalPrice);
    }


}

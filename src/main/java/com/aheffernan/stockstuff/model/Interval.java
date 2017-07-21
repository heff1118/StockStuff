package com.aheffernan.stockstuff.model;

public class Interval {

    public enum IntervalEnum {
        NEVER,
        HOURLY,
        DAILY,
        WEEKLY,
        MONTHLY;
    }

    /**
     * @param text
     * @return
     */
    public static IntervalEnum valueOf(String text) {
        text = text.toLowerCase();
        for (IntervalEnum internal : IntervalEnum.values()) {
            if (internal.toString().toLowerCase().equals(text)) {
                return internal;
            }
        }
        return null;
    }
}

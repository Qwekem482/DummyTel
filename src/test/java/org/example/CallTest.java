package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CallTest {
    Call[] records = {
            new Call(LocalDateTime.of(2023,2,12, 23,39), Duration.ofSeconds(30)),
            new Call(LocalDateTime.of(2023, 2, 12, 18, 0), Duration.ofSeconds(3660)),
            new Call(LocalDateTime.of(2023, 2, 12, 15, 30), Duration.ofSeconds(3600)),
            new Call(LocalDateTime.of(2023, 2, 12, 8, 0), Duration.ofSeconds(3660))
    };

    @Test
    void isBefore() {
        assertAll(() -> assertTrue(Call.IsOutside(records[0].getStartCall())),
                () -> assertTrue(Call.IsOutside(records[1].getStartCall())),
                () -> assertFalse(Call.IsOutside(records[2].getStartCall())),
                () -> assertFalse(Call.IsOutside(records[3].getStartCall())));
    }

    @Test
    void isOverSixty() {
        assertAll(() -> assertFalse(Call.IsOver(records[0].getCallTime())),
                () -> assertTrue(Call.IsOver(records[1].getCallTime())),
                () -> assertFalse(Call.IsOver(records[2].getCallTime())),
                () -> assertTrue(Call.IsOver(records[3].getCallTime())));
    }

    @Test
    void setPrice() {
        assertAll(() -> assertEquals(0.14, records[0].getPrice()),
                () -> assertEquals(13.62, records[1].getPrice()),
                () -> assertEquals(31.5, records[2].getPrice()),
                () -> assertEquals(27.23, records[3].getPrice()));
    }
}
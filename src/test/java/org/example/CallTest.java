package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CallTest {
    Call[] epRecords = {
            new Call(LocalTime.of(9,0,0), Duration.ofSeconds(5400)),
            new Call(LocalTime.of(9, 0,0), Duration.ofSeconds(2700)),
            new Call(LocalTime.of(9, 0,0), Duration.ofSeconds(-1)),
            new Call(LocalTime.of(21, 0,0), Duration.ofSeconds(5400)),
            new Call(LocalTime.of(21, 0,0), Duration.ofSeconds(2700)),
            new Call(LocalTime.of(21, 0,0), Duration.ofSeconds(-1))
    };

    Duration[] evaDurations = {
            Duration.ofSeconds(-10),
            Duration.ofSeconds(-1),
            Duration.ofSeconds(0),
            Duration.ofSeconds(1),
            Duration.ofSeconds(2700),
            Duration.ofSeconds(3599),
            Duration.ofSeconds(3600),
            Duration.ofSeconds(3601),
            Duration.ofSeconds(5400)
    };

    LocalTime[] evaTimes = {
            LocalTime.of(8,0,0),
            LocalTime.of(8,0,1),
            LocalTime.of(13,0,0),
            LocalTime.of(17,59,59),
            LocalTime.of(18,0,0),
            LocalTime.of(18,0,1),
            LocalTime.of(0,0,0),
            LocalTime.of(7,59,59)
    };

    private Call[] createEVARecords() {
        Call[] records = new Call[72];
        int index = 0;

        for (LocalTime time: evaTimes) {
            for (Duration duration: evaDurations) {
                records[index] = new Call(time, duration);
                index++;
            }
        }

        return records;
    }

    @Test
    void equivalencePartitioning() {
        assertAll(() -> assertEquals(40.17, epRecords[0].getPrice()),
                () -> assertEquals(23.63, epRecords[1].getPrice()),
                () -> assertThrows(Exception.class, () -> epRecords[2].getPrice()),
                () -> assertEquals(20.09, epRecords[3].getPrice()),
                () -> assertEquals(11.82, epRecords[4].getPrice()),
                () -> assertThrows(Exception.class, () -> epRecords[5].getPrice()));

    }

    @Test
    void marginalValueAnalysis() {
        Call[] mvaRecords = createEVARecords();
        int count = 0;

        for(int i = 1; i < 5; i++) {
            int index = count;
            assertAll(() -> assertThrows(Exception.class, () -> mvaRecords[index].getPrice()),
                    () -> assertThrows(Exception.class, () -> mvaRecords[index + 1].getPrice()),
                    () -> assertEquals(0, mvaRecords[index + 2].getPrice()),
                    () -> assertEquals(0.53, mvaRecords[index + 3].getPrice()),
                    () -> assertEquals(23.63, mvaRecords[index + 4].getPrice()),
                    () -> assertEquals(31.5, mvaRecords[index + 5].getPrice()),
                    () -> assertEquals(31.5, mvaRecords[index + 6].getPrice()),
                    () -> assertEquals(32.03, mvaRecords[index + 7].getPrice()),
                    () -> assertEquals(40.17, mvaRecords[index + 8].getPrice()));
            count = count + 9;
        }

        for(int i = 1; i < 5; i++) {
            int index = count;
            assertAll(() -> assertThrows(Exception.class, () -> mvaRecords[index].getPrice()),
                    () -> assertThrows(Exception.class, () -> mvaRecords[index + 1].getPrice()),
                    () -> assertEquals(0, mvaRecords[index + 2].getPrice()),
                    () -> assertEquals(0.27, mvaRecords[index + 3].getPrice()),
                    () -> assertEquals(11.82, mvaRecords[index + 4].getPrice()),
                    () -> assertEquals(15.75, mvaRecords[index + 5].getPrice()),
                    () -> assertEquals(15.75, mvaRecords[index + 6].getPrice()),
                    () -> assertEquals(16.02, mvaRecords[index + 7].getPrice()),
                    () -> assertEquals(20.09, mvaRecords[index + 8].getPrice()));
            count = count + 9;
        }
    }
}
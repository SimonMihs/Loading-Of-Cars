package ru.liga.truck.sevice.imp;

import org.junit.jupiter.api.Test;
import ru.liga.sevice.CheckInParcelService;
import ru.liga.sevice.imp.CheckInParcelServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class CheckInParcelServiceImplTest {


    private CheckInParcelService checkInParcelService = new CheckInParcelServiceImpl();

    @Test
    void testCheckInParcel_ParcelFits() {
        int[][] parcel = {{1, 1, 1}, {1, 1, 1}};
        int[][] scheme = {{0, 0, 0}, {0, 0, 0}};
        assertEquals(0, checkInParcelService.checkInParcel(parcel, scheme));
    }
    @org.junit.jupiter.api.Test
    void testCheckInParcel_ParcelFits1() {
        int[][] parcel = {{1, 1, 1}, {1, 1, 1}};
        int[][] scheme = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        assertEquals(1, checkInParcelService.checkInParcel(parcel, scheme));
    }
    @Test
    void testCheckInParcel_ParcelFitsWithGaps3() {
        int[][] parcel = {{1, 1}, {1, 1}};
        int[][] scheme = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 1},{0, 0, 0, 0, 0},{0, 0, 0, 0, 0}};
        assertEquals(0, checkInParcelService.checkInParcel(parcel, scheme));
    }
}
package ru.liga.truck.sevice.imp;

import org.junit.jupiter.api.Test;
import ru.liga.service.impl.MachineLoaderServiceOptimalImpl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MachineLoaderServiceOptimalImplTest {

    private MachineLoaderServiceOptimalImpl checkInParcel = new MachineLoaderServiceOptimalImpl();

    @Test
    void testCheckInParcel_ParcelFits() {
        int[][] parcel = {{1, 1, 1}, {1, 1, 1}};
        int[][] scheme = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
       // assertEquals(1, checkInParcel.checkInParcel(parcel, scheme));
    }

    @Test
    void testGetStartPosition_MultipleZeros() {
        int[] lineShem = {1, 0, 1, 1, 1, 0, 0, 0, 1};
 //       assertEquals(5, checkInParcel.getStartPosition(lineShem));
    }

    @Test
    void testAddParcels_ParcelFitsWithGaps2() {
        int[][] parcel = {{1, 1, 1}, {1, 1, 1}};
        int[][] scheme = {{1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[][] expectedScheme = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[][] resultScheme = checkInParcel.addParcels(parcel, 6, 6, scheme);
        assertArrayEquals(expectedScheme, resultScheme);
    }
@Test
    void testAddParcels_ParcelFitsWithGaps3() {
        int[][] parcel = {{1}};
        int[][] scheme = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[][] expectedScheme = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[][] resultScheme = checkInParcel.addParcels(parcel, 6, 6, scheme);
        assertArrayEquals(expectedScheme, resultScheme);
    }
}
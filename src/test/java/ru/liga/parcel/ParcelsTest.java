package ru.liga.parcel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParcelsTest {

    @Test
    void testEmptyParcels() {
        List<int[][]> emptyParcels = new ArrayList<>();
        Parcels parcels = new Parcels(emptyParcels);
        LinkedHashMap<ParcelContainer, Integer> result = parcels.getParcel();
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleParcel() {
        List<int[][]> parcelsInt = new ArrayList<>();
        int[][] parcel1 = {{6, 6, 6}, {6, 6, 6}};
        int[][] parcel2 = {{2, 2}};
        parcelsInt.add(parcel1);
        parcelsInt.add(parcel2);
        Parcels parcels = new Parcels(parcelsInt);
        LinkedHashMap<ParcelContainer, Integer> result = parcels.getParcel();
        assertEquals(1, result.size());
        assertTrue(result.containsKey(new ParcelContainer(parcel1)));
        assertEquals(1, result.get(new ParcelContainer(parcel1)));
    }

    @Test
    void testDuplicateParcels() {
        List<int[][]> parcelsInt = new ArrayList<>();
        int[][] parcel1 = {{1, 2}, {3, 4}};
        int[][] parcel2 = {{1, 2}, {3, 4}};
        parcelsInt.add(parcel1);
        parcelsInt.add(parcel2);
        Parcels parcels = new Parcels(parcelsInt);
        LinkedHashMap<ParcelContainer, Integer> result = parcels.getParcel();
        assertEquals(1, result.size());
        assertTrue(result.containsKey(new ParcelContainer(parcel1)));
        assertEquals(2, result.get(new ParcelContainer(parcel1)));
    }

    @Test
    void testDifferentParcels() {
        List<int[][]> parcelsInt = new ArrayList<>();
        int[][] parcel1 = {{1, 2}, {3, 4}};
        int[][] parcel2 = {{5, 6}, {7, 8}};
        parcelsInt.add(parcel1);
        parcelsInt.add(parcel2);
        Parcels parcels = new Parcels(parcelsInt);
        LinkedHashMap<ParcelContainer, Integer> result = parcels.getParcel();
        assertEquals(2, result.size());
        assertTrue(result.containsKey(new ParcelContainer(parcel1)));
        assertEquals(1, result.get(new ParcelContainer(parcel1)));
        assertTrue(result.containsKey(new ParcelContainer(parcel2)));
        assertEquals(1, result.get(new ParcelContainer(parcel2)));
    }

}
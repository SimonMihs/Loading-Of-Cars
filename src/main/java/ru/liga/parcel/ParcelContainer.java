package ru.liga.parcel;

import java.util.Arrays;

public class ParcelContainer {

    private final int[][] parcel;


    public ParcelContainer(int[][] parcel) {
        this.parcel = parcel;
    }


    public int[][] getParcel() {
        return parcel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcelContainer that = (ParcelContainer) o;
        return Arrays.deepEquals(parcel, that.parcel);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(parcel);
    }

}
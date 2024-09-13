  package ru.liga.parcel;

import java.util.Arrays;

public class ParcelContainer {

    private final int[][] parcel;


    public ParcelContainer(int[][] parcel) {
        if (parcel == null) {
            throw new IllegalArgumentException("Посылка не может быть null");
        }
        this.parcel = deepCopy(parcel);
    }


    public int[][] getParcel() {
        return deepCopy(parcel);
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

    @Override
    public String toString() {
        return "ParcelContainer{" +
               "parcel=" + Arrays.deepToString(parcel) +
               '}';
    }

    private int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }
        int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

}
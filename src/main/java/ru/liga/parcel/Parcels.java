package ru.liga.parcel;

import java.util.LinkedHashMap;
import java.util.List;


public class Parcels {

    private final LinkedHashMap<ParcelContainer, Integer> parcel;
    private final List<int[][]> parcelList;

    public Parcels(List<int[][]> parcelsInt) {
        this.parcel = new LinkedHashMap<>();
        this.parcelList = parcelsInt;
        setParcels(parcelsInt);
    }

    public List<int[][]> getParcelList() {
        return parcelList;
    }

    private void setParcels(List<int[][]> parcelsInt) {
        for (int[][] inParcel : parcelsInt) {
            ParcelContainer parcelContainer = new ParcelContainer(inParcel);
            if (parcel.containsKey(parcelContainer)) {
                parcel.put(parcelContainer, parcel.get(parcelContainer) + 1);
            } else {
                parcel.put(parcelContainer, 1);
            }
        }
    }

    public LinkedHashMap<ParcelContainer, Integer> getParcel() {

        return parcel;

    }

    public int getTotalParcelCount() {
        return parcelList.size();
    }

}

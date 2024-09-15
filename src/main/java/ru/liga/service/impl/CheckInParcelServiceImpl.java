package ru.liga.service.impl;

import ru.liga.service.CheckInParcelService;

public class CheckInParcelServiceImpl implements CheckInParcelService {
    @Override
    public int checkInParcel(int[][] parcel, int[][] scheme) {

        int parcelHeights = parcel.length;
        int parcelWidths = parcel[parcel.length - 1].length;
        int lineWidths = 0;
        int lineMaxWidths = 0;
        for (int i = 0; i < scheme.length; i++) {

            int[] lain = scheme[i];
            for (int j = 0; j < lain.length; j++) {

                if (lain[j] == 0) {
                    if (i == 0 || scheme[i - 1][j] != 0) {
                        lineWidths++;
                    } else {
                        if (lineWidths > lineMaxWidths) {
                            lineMaxWidths = lineWidths;
                        }
                        lineWidths = 0;
                    }
                } else {
                    lineWidths = 0;
                }
            }
            if (lineMaxWidths >= parcelWidths || lineWidths >= parcelWidths) {
                if (scheme.length - i >= parcelHeights) {
                    return i;
                }
            }
        }
        return -1;
    }
}

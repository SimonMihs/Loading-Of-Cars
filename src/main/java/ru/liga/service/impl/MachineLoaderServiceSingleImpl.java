package ru.liga.service.impl;

import ru.liga.service.CheckInParcelService;
import ru.liga.service.GetStartPositionService;
import ru.liga.service.MachineLoaderService;

import java.util.Arrays;

public class MachineLoaderServiceSingleImpl implements MachineLoaderService {

    CheckInParcelService checkInParcelService;
    GetStartPositionService getStartPositionService;

    public MachineLoaderServiceSingleImpl() {
        this.getStartPositionService = new GetStartPositionServiceImpl();
        this.checkInParcelService = new CheckInParcelServiceImpl();
    }

    @Override
    public int[][] addParcels(int[][] parcel, int heightMax, int widthMax, int[][] scheme) {
        if (Arrays.stream(scheme[0]).sum() > 0) {
            return null;
        }
        int widths = parcel[parcel.length - 1].length;
        int heights = parcel.length;
        int k = parcel.length - 1;
        int l = 0;
        int startI = checkInParcelService.checkInParcel(parcel, scheme);

        if (startI >= 0) {
            int startJ = getStartPositionService.getStartPosition(scheme[startI]);
            for (int i = startI; i < startI + heights; i++) {
                for (int j = startJ; j < startJ + widths; j++) {
                    scheme[i][j] = parcel[k][l];
                    l++;
                }
                l = 0;
                k--;
            }
            return scheme;
        }
        return null;
    }

}


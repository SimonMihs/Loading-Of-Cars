package ru.liga.sevice.imp;

import ru.liga.sevice.CheckInParcelService;
import ru.liga.sevice.GetStartPositionService;
import ru.liga.sevice.MachineLoaderService;

public class MachineLoaderServiceOptimalImpl implements MachineLoaderService {

    CheckInParcelService checkInParcelService;
    GetStartPositionService getStartPositionService;

    public MachineLoaderServiceOptimalImpl() {
        this.getStartPositionService = new GetStartPositionServiceImpl();
        this.checkInParcelService = new CheckInParcelServiceImpl();
    }

    @Override
    public int[][] addParcels(int[][] parcel, int heightMax, int widthMax, int[][] scheme) {
        int widths = parcel[parcel.length - 1].length;
        int heights = parcel.length;
        int k = parcel.length - 1;
        int l = 0;
        int[][] resScheme = scheme;
        int startI = checkInParcelService.checkInParcel(parcel, scheme);

        if (startI >= 0) {
            int startJ = getStartPositionService.getStartPosition(scheme[startI]);
            for (int i = startI; i < startI + heights; i++) {
                for (int j = startJ; j < startJ + widths; j++) {
                    resScheme[i][j] = parcel[k][l];
                    l++;
                }
                l = 0;
                k--;
            }
            return resScheme;
        }
        return null;
    }

}




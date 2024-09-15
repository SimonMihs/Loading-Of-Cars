package ru.liga.service.impl;


import ru.liga.service.MachineLoaderService;

public class MachineLoaderServiceBaseImpl implements MachineLoaderService {
    private int heightMax = 0;
    private int widthMax = 0;
    private int startI = 0;
    private int startJ = 0;

    @Override
    public int[][] addParcels(int[][] parcel, int heightMax, int widthMax, int[][] scheme) {

        updateParam(scheme, heightMax, widthMax);
        int widths = parcel[parcel.length - 1].length;
        int heights = parcel.length;
        int k = parcel.length - 1;
        int l = 0;
        int[][] field1 = scheme;

        if (heightMax >= parcel.length + startI && widthMax >= parcel[0].length + startJ) {
            for (int i = startI; i < startI + heights; i++) {
                for (int j = startJ; j < startJ + widths; j++) {
                    field1[i][j] = parcel[k][l];
                    l++;
                }
                l = 0;
                k--;
            }
            updateParam(field1, heightMax, widthMax);
            return field1;
        }
        return null;
    }
    private void updateParam(int[][] field, int height, int width) {
        int maxH = 0;
        int maxW = 0;
        int[] startJTemp = new int[height];
        for (int i = 0; i < height; i++) {
            int widthTemp = 0;
            maxH = 0;
            for (int j = 0; j < width; j++) {
                int temp = field[i][j];
                if ((temp == 0 && i == 0) || (i != 0 && field[i][j] == 0 && field[i - 1][j] == 1)) {
                    widthTemp++;

                    if ((field[i][j] == 0) && maxH == 0) {
                        startJTemp[i] = j;
                        maxH = 1;

                    }

                }
            }
            if (widthTemp > maxW) {
                heightMax = height - i;
                maxW = widthTemp;
                widthMax = widthTemp;
                startI = i;
                startJ = startJTemp[i];
            }
        }
    }

}




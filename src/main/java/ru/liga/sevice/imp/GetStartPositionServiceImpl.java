package ru.liga.sevice.imp;

import ru.liga.sevice.GetStartPositionService;

public class GetStartPositionServiceImpl implements GetStartPositionService {
    @Override
    public int getStartPosition(int[] lineShem) {
        int maxLength = 0;
        int startPosition = -1;
        int currentLength = 0;

        for (int i = 0; i < lineShem.length; i++) {
            if (lineShem[i] == 0) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startPosition = i - currentLength + 1;
                }
            } else {
                currentLength = 0;
            }
        }

        return startPosition;
    }
}

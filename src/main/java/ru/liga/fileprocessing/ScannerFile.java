package ru.liga.fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ScannerFile {

    public List<int[][]> parsFile(String filePath) {

        try {
            Path path = Paths.get(filePath);
            Stream<String> lines = Files.lines(path);

            return stringProcess(lines.toArray(String[]::new));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<int[][]> stringProcess(String[] lines) {
        List<int[][]> parcels = new ArrayList<>();
        List<String> parcelList = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].isEmpty()) {

                parcelList.add(lines[i]);

            } else {

                parcels.add(intParcel(parcelList));
                parcelList.clear();

            }

        }

        if(!parcelList.isEmpty()){
            parcels.add(intParcel(parcelList));
            parcelList.clear();
        }

        return parcels;

    }

    private int[][] intParcel(List<String> parcel) {

        int[][] intMass = new int[parcel.size()][parcel.getLast().length()];

        for (int i = 0; i < parcel.size(); i++) {
            String str = parcel.get(i);
            for (int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                intMass[i][j] = Character.getNumericValue(letter);
            }

        }

        return intMass;

    }

}

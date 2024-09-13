package ru.liga.fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileScanner {

    public List<int[][]> parseFile(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return processStrings(lines.toList());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }

    private List<int[][]> processStrings(List<String> lines) {
        List<int[][]> parcels = new ArrayList<>();
        List<String> currentParcel = new ArrayList<>();

        for (String line : lines) {
            if (!line.isEmpty()) {
                currentParcel.add(line);
            } else if (!currentParcel.isEmpty()) {
                parcels.add(convertToIntArray(currentParcel));
                currentParcel.clear();
            }
        }

        if (!currentParcel.isEmpty()) {
            parcels.add(convertToIntArray(currentParcel));
        }

        return parcels;
    }

    private int[][] convertToIntArray(List<String> parcel) {
        int[][] intArray = new int[parcel.size()][parcel.getLast().length()];

        for (int i = 0; i < parcel.size(); i++) {
            String str = parcel.get(i);
            for (int j = 0; j < str.length(); j++) {
                intArray[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        return intArray;
    }
}

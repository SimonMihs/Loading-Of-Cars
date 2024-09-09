package ru.liga.fileprocessing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScannerFileTest {


    @Test
    public void testparsFile_ValidFile() {
        // Arrange
        ScannerFile container = new ScannerFile(); // Предполагаем, что у вас есть класс ParcelContainer
        String filePath = "src/main/resources/data"; // Путь к вашему тестовому файлу

        //String[] parcels = ;

        assertNotNull(container.parsFile(filePath));

    }



}
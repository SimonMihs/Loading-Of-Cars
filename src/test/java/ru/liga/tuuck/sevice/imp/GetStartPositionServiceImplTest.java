package ru.liga.tuuck.sevice.imp;

import org.junit.jupiter.api.Test;
import ru.liga.sevice.GetStartPositionService;
import ru.liga.sevice.imp.GetStartPositionServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class GetStartPositionServiceImplTest {

    private GetStartPositionService getStartPositionService = new GetStartPositionServiceImpl();
@Test
    void testGetStartPosition_MultipleZeros() {
        int[] lineShem = {1, 0, 1, 1, 1, 0, 0, 0, 1};
        assertEquals(5, getStartPositionService.getStartPosition(lineShem));
    }
    @Test
    void testGetStartPosition_1() {
        int[] lineShem = {0, 0, 0 ,0 , 0, 0, 0, 0, 1};
        assertEquals(0, getStartPositionService.getStartPosition(lineShem));
    }
    @Test
    void testGetStartPosition_2() {
        int[] lineShem = {1, 0, 0, 0, 0, 0, 0, 0, 1};
        assertEquals(1, getStartPositionService.getStartPosition(lineShem));
    }
}
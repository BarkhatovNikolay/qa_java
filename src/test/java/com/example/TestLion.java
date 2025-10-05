package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestLion {

    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals("Должен возвращать кол-во котят = ", 1, lion.getKittens());
        verify(feline, times(1)).getKittens();
    }
    @Test
    public void testLionHasManeMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void testLionHasManeFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }
    @Test
    public void testGetFoodLionsFemale() throws Exception{
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", feline);
        assertEquals("метод getFood должен возвращать еду для хищников", expectedFood, lion.getFood());
        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodLionsMale() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        assertEquals("метод getFood должен возвращать еду для хищников", expectedFood, lion.getFood());
        verify(feline, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        new Lion("Неизвестный", feline);
    }
}

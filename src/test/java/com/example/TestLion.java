package com.example;

import org.junit.Before;
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
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }
    @Test
    public void testGetKittensReturnCorrectValue() {
        when(feline.getKittens()).thenReturn(1);
        assertEquals("Должен возвращать кол-во котят = ", 1, lion.getKittens());
    }

    @Test
    public void testGetKittensCallsFelineMethods() {
        when(feline.getKittens()).thenReturn(1);
        lion.getKittens();
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnCorrectFood() throws Exception{
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals("метод getFood должен возвращать еду для хищников", expectedFood, lion.getFood());
    }
    @Test
    public void testGetFoodCallsEatMeat() throws Exception{
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        lion.getFood();
        verify(feline, times(1)).eatMeat();
    }


    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        new Lion("Неизвестный", feline);
    }
}

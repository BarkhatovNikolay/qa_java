package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        Assert.assertEquals("getSound должен возвращать 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnCorrectFoodTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("getFood должен возвращать еду для хищников от Feline", expectedFood, actualFood);
        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void getFoodReturnCallsEatMeatTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        cat.getFood();
        verify(feline, times(1)).eatMeat();
    }
}
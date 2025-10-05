package com.example;

import org.junit.Assert;
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
    @Test
        public void getSoundTest(){
            Cat cat = new Cat(feline);
            Assert.assertEquals("getSound должен возвращать 'Мяу'", "Мяу", cat.getSound());
    }
    @Test
        public void getFoodTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("getFood должен возвращать еду для хищников от Feline", expectedFood, actualFood);
        verify(feline, times(1)).eatMeat();

    }
}

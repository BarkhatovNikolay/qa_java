package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestAnimal {
    private Animal animal;
    @Before
    public void setUp() {
        animal = new Animal();
    }
    @Test
    public void getFoodForHerbivoresTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Трава", "Различные растения");
        Assert.assertEquals("Должна быть еда для травоядных", expectedFood, animal.getFood("Травоядное"));
    }
    @Test
    public void getFoodForPredatorsTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Должна быть еда для хищников]", expectedFood, animal.getFood("Хищник"));
    }
    @Test(expected = Exception.class)
    public void getFoodForUnknownAnimal() throws Exception {
        animal.getFood("Неизвестный");
    }
    @Test
    public void getFamilyTest(){
        String expectedText = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals("Возврщаемый текст не соответствует", expectedText, animal.getFamily());
    }
}

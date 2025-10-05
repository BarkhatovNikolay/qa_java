package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestAnimal {
    @Test
    public void getFoodForHerbivoresTest() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = Arrays.asList("Трава", "Различные растения");
        Assert.assertEquals("Должна быть еда для травоядных", expectedFood, animal.getFood("Травоядное"));
    }
    @Test
    public void getFoodForPredatorsTest() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Должна быть еда для хищников]", expectedFood, animal.getFood("Хищник"));
    }
    @Test(expected = Exception.class)
    public void getFoodForUnknownAnimal() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный");
    }
    @Test
    public void getFamilyTest(){
        Animal animal = new Animal();
        String expectedText = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals("Возврщаемый текст не соответствует", expectedText, animal.getFamily());
    }
}

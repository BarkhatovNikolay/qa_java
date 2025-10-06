package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestFeline {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals("eatMeat Должен возвращать еду для хищников", expectedFood, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("getFamily Должен возвращать семейство кошачьих", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParameterTest(){
        Assert.assertEquals("getKittens Должен возвращать 1 без параметров", 1, feline.getKittens());
    }
    @Test
    public void getKittensWithParameterTest(){
        int kittensCount = 4;
        Assert.assertEquals("getKittens должен возвращать число переданное в параметре", kittensCount, feline.getKittens(kittensCount));
    }

}

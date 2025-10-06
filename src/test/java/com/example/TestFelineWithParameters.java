package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestFelineWithParameters {
    private final int kittenCounts;
    private final int expectedKittenCounts;

    public TestFelineWithParameters(int kittenCounts, int expectedKittenCounts) {
        this.kittenCounts = kittenCounts;
        this.expectedKittenCounts = expectedKittenCounts;
    }

    @Parameterized.Parameters(name = "Тестовые данные: количество котят={0}, ожидается={1}")
    public static Object[][] testKittenData() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4}
        };

    }
    @Test
    public void getKittensWithDifferentCount(){
        Feline feline = new Feline();
        Assert.assertEquals("Колличество должно совпадать параметру", expectedKittenCounts, feline.getKittens(kittenCounts));
    }
}

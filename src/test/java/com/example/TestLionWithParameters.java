package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class TestLionWithParameters {

    private final String sex;
    private final boolean expectedHasMane;

    public TestLionWithParameters(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;

    }
    @Parameterized.Parameters(name = "Тестовые данные: пол={0}, ожидается грива={1}")
    public static Object[][] testLionData(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void testLionManeBasedOnSex() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        assertEquals("Грива льва должна соответствовать полу", expectedHasMane, lion.doesHaveMane());
    }



}

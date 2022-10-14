package Calculation;

import Operators.Operators;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static Operators.Operators.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FunctionMapTest {

    FunctionMap calculatorMap;

    Operators operator;
    long a;

    long b;
    double expectedResult;

    public FunctionMapTest(Operators operator, long a, long b, long expectedResult){

        this.operator = operator;
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;

    }

    @Parameterized.Parameters
    public static Collection collection (){

        return Arrays.asList(new Object[][]{

                {ADDITION, 3, 5, 8},
                {SUBTRACTION, 5, 15, 10},
                {MULTIPLICATION, 33, 3, 99},
                {DIVISION, 5, 45, 9}

        });

    }

    @Before
    public void setUp() throws Exception {

        calculatorMap = new FunctionMapImpl();

    }

    @Test
    public void calculate() {

        assertEquals(expectedResult, calculatorMap.calculate(operator, a, b), 0);

    }
}
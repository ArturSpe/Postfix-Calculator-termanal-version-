package Operators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static Operators.Operators.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OperatorsTest {

    String operator;
    Operators expectedOperator;

    public OperatorsTest (String operator, Operators actualOperators){

        this.operator = operator;
        this.expectedOperator = actualOperators;

    }

    @Parameterized.Parameters
    public static Collection collection (){

        return Arrays.asList(new Object[][]{{"+", ADDITION}, {"*", MULTIPLICATION}, {"-", SUBTRACTION}});

    }

    @Test
    public void getOperator() {

        Operators actualOperators = Operators.getOperatorFromString(operator);
        assertEquals(expectedOperator, actualOperators);

    }

}
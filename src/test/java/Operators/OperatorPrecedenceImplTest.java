package Operators;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static Operators.Operators.*;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class OperatorPrecedenceImplTest {

    private OperatorPrecedence operatorPrecedence;

    int expectedPriority;
    Operators actualOperator;

    public OperatorPrecedenceImplTest(int expectedPriority, Operators actualOperator){

        this.expectedPriority = expectedPriority;
        this.actualOperator = actualOperator;

    }

    @Parameterized.Parameters
    public static Collection collection (){

        return Arrays.asList(new Object[][]{{0, SUBTRACTION}, {1, DIVISION}, {2, OPEN_BRACKET}, {3, CLOSING_BRACKET}});

    }

    @Before
    public void setUp() throws Exception {

        operatorPrecedence = new OperatorPrecedenceImpl();

    }

    @Test
    public void getPriority() {

        assertEquals(expectedPriority, operatorPrecedence.getPriority(actualOperator));

    }
}
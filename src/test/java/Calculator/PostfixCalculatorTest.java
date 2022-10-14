package Calculator;

import Calculation.FunctionMap;
import Calculation.FunctionMapImpl;
import Operators.OperatorPrecedence;
import Operators.OperatorPrecedenceImpl;
import StringsProcessing.ParsingString;
import StringsProcessing.TransformationString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PostfixCalculatorTest {

    double expectedResult;
    String expression;
    FunctionMap functionMap;
    Calculator calculator;
    TransformationString transformationString;
    OperatorPrecedence operatorPrecedence;

    public PostfixCalculatorTest (String expression, double expectedResult){
        this.expression = expression;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection collection(){

        return Arrays.asList(new Object[][]{{"1+2/4", 1.5}, {"22*(3+8)", 242.0},
                {"1/2/2/2", 0.125}});
    }

    @Before
    public void setUp() throws Exception {

        transformationString = new ParsingString();
        operatorPrecedence = new OperatorPrecedenceImpl();
        functionMap = new FunctionMapImpl();
        calculator = new PostfixCalculator((ParsingString) transformationString, (OperatorPrecedenceImpl) operatorPrecedence, (FunctionMapImpl) functionMap);
    }

    @Test
    public void calculate() {
        assertEquals(expectedResult,calculator.calculate(expression), 0);
    }
}
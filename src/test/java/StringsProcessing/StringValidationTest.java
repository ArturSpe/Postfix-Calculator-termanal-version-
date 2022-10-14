package StringsProcessing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringValidationTest {

    StringValidation stringValidation;

    boolean expectedResult;
    String string;

    public StringValidationTest (boolean expectedResult, String string){

        this.expectedResult = expectedResult;
        this.string = string;

    }

    @Parameterized.Parameters
    public static Collection collection (){

        return Arrays.asList(new Object[][]{{true, "1+2*(4+5)"}, {true, "(((1+2)*3)*4)*2"},
                {false, "(1+2+3"}, {false, "+1+2"}, {false, "((2+4))-)4+5)"}, {false, "2+3+d"}});

    }

    @Before
    public void setUp() throws Exception {

        stringValidation = new StringValidationImpl();

    }


    @Test
    public void checkString() throws Exception {

        try {
            assertEquals(expectedResult, stringValidation.checkString(string));
        }catch (Exception e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}
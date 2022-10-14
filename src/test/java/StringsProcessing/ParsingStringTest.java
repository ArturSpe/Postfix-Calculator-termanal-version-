package StringsProcessing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParsingStringTest {

    TransformationString transformationString1;
    TransformationString transformationString2;

    @Before
    public void setUp() throws Exception {

        transformationString1 = new ParsingString();
        transformationString2 = new ParsingString();

    }

    @Test
    public void stringToList() {

        String expression = "(1+3)+3*5";
        String [] expected = {"(", "1", "+", "3", ")", "+", "3", "*", "5"};
        ArrayList <String> expectedArray = new ArrayList<>(List.of(expected));

        assertEquals(expectedArray, transformationString2.stringToList(expression));

    }


    @Test
    public void toPostfix() {

        String [] expression = {"(", "1", "+", "2", ")", "*", "3", "*", "(", "1", "+", "2", ")"};
        String [] expected = {"1", "2", "+", "3", "*", "1", "2", "+", "*"};
        ArrayList <String> expectedArray = new ArrayList<>(List.of(expected));

        assertEquals(expectedArray, transformationString1.toPostfix(List.of(expression)));

    }
}
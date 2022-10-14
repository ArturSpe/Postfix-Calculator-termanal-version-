package Operators;

import java.util.HashMap;
import java.util.Map;

public class OperatorPrecedenceImpl implements OperatorPrecedence {

    Map<Operators, Integer> mapPriority;

    public OperatorPrecedenceImpl(){

        mapPriority = new HashMap<>();

        mapPriority.put(Operators.ADDITION, 0);
        mapPriority.put(Operators.SUBTRACTION, 0);
        mapPriority.put(Operators.DIVISION, 1);
        mapPriority.put(Operators.MULTIPLICATION, 1);
        mapPriority.put(Operators.OPEN_BRACKET, 2);
        mapPriority.put(Operators.CLOSING_BRACKET, 3);

    }

    @Override
    public int getPriority(Operators operator) {
        return mapPriority.get(operator);
    }

}

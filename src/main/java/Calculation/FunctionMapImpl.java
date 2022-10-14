package Calculation;

import Calculation.Functions.*;
import Operators.Operators;
import java.util.HashMap;
import java.util.Map;

public class FunctionMapImpl implements FunctionMap {

    private final Map<Operators, IFunction> accountantMap;

    public FunctionMapImpl(){
        accountantMap = new HashMap<>();
        accountantMap.put(Operators.ADDITION, new Sum());
        accountantMap.put(Operators.SUBTRACTION, new Subtraction());
        accountantMap.put(Operators.MULTIPLICATION, new Multiplication());
        accountantMap.put(Operators.DIVISION, new Division());
    }

    @Override
    public double calculate(Operators operator, double a, double b) {
        return accountantMap.get(operator).count(a, b);
    }

}

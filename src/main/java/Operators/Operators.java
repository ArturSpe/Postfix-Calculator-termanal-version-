package Operators;

import java.util.HashMap;
import java.util.Map;

public enum Operators {


    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    OPEN_BRACKET ("("),
    CLOSING_BRACKET (")");

    private final String operator;
    Operators(String operator){
        this.operator = operator;

    }

    private static final Map<String, Operators> OPERATORS_MAP = new HashMap<>();

    static {
        for (Operators operator : values()){
            OPERATORS_MAP.put(operator.getString(), operator);
        }

    }

    public String getString(){
        return operator;
    }

    public static Operators getOperatorFromString(String operator){
        return OPERATORS_MAP.get(operator);
    }

}

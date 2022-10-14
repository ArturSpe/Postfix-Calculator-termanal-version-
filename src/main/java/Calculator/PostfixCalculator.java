package Calculator;

import Calculation.FunctionMapImpl;
import Operators.OperatorPrecedenceImpl;
import Operators.Operators;
import StringsProcessing.ParsingString;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostfixCalculator extends CalculatorHelper implements Calculator {

    public PostfixCalculator (ParsingString parsingString, OperatorPrecedenceImpl operatorPrecedence, FunctionMapImpl calculation){
        super(parsingString, operatorPrecedence, calculation);
    }

    @Override
    public double calculate(String expression) {

        String[] operators = Arrays.stream(Operators.values()).map(x -> x.getString()).toList().toArray(new String[0]);
        ArrayList<String> operatorList = new ArrayList<>(List.of(operators));
        ArrayDeque<Double> numbers = new ArrayDeque<>();
        String[] postfix = transformationString.toPostfix(transformationString.stringToList(expression)).toArray(new String[0]);

        //Если символ является оператором, то достаем из стека два числа, считаем и результат кладем обратно в стек
        for (String symbol : postfix){
            if (operatorList.contains(symbol)){
                numbers.addLast(calculation.calculate(Operators.getOperatorFromString(symbol), numbers.pollLast(), numbers.pollLast()));
            }else {
                numbers.addLast(Double.parseDouble(symbol));
            }
        }

        return numbers.pollLast();
    }
}

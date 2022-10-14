package StringsProcessing;

import Operators.Operators;

import java.util.*;

import Operators.*;

public class ParsingString implements TransformationString {

    private final StringBuilder operators;
    private StringBuilder helperString;
    private final List<String> resultArray;

    private final OperatorPrecedenceImpl operatorPrecedence;

    public ParsingString(){

        operators = new StringBuilder();
        helperString = new StringBuilder();
        resultArray = new ArrayList<>();
        operatorPrecedence = new OperatorPrecedenceImpl();

        for (Operators operator : Operators.values()){
            operators.append(operator.getString());
        }

    }
    @Override
    public List<String> stringToList(String string) {

        string = string.replaceAll(" ", "")
                .replaceAll(",", ".")
                .replaceAll("×", "*");

        //Пока не встретили символ(из перечислений), формируем число в вспомогательной строке
        //Как только попался символ, добавляем число и сам символ в результирующий список
        for (int i = 0; i < string.length(); i++) {
            if (operators.indexOf(String.valueOf(string.charAt(i))) == -1) {
                helperString.append(string.charAt(i));
            }

            if (operators.indexOf(String.valueOf(string.charAt(i))) != -1) {
                if (helperString.length() != 0) {
                    resultArray.add(helperString.toString());
                }

                resultArray.add(String.valueOf(string.charAt(i)));
                helperString = new StringBuilder();

            }

            if (i == string.length() - 1) {
                resultArray.add(helperString.toString());
            }

            if (resultArray.size() != 0 && resultArray.get(resultArray.size() - 1) == ""){
                resultArray.remove("");
            }

        }

        return resultArray;

    }
    @Override
    public List<String> toPostfix(List<String> list) {

        Deque<String> helperDeque = new ArrayDeque<String>();
        ArrayList<String> resultString = new ArrayList<>();
        String[] operators = Arrays.stream(Operators.values()).map(x -> x.getString()).toList().toArray(new String[0]);
        ArrayList<String> operatorList = new ArrayList<String>(List.of(operators));

        for (String symbol : list){

            if (!operatorList.contains(symbol)){
                resultString.add(symbol);
            }

            if (operatorList.contains(symbol)){
                if (symbol.equals(Operators.OPEN_BRACKET.getString())){
                    helperDeque.addLast(symbol);
                }

                else if (symbol.equals(Operators.CLOSING_BRACKET.getString())) {
                    while (helperDeque.size() != 0 && !helperDeque.peekLast().equals(Operators.OPEN_BRACKET.getString())){
                        resultString.add(helperDeque.pollLast());
                    }helperDeque.pollLast();

                }else {
                    if (helperDeque.size() != 0 && !helperDeque.peekLast().equals(Operators.OPEN_BRACKET.getString())){
                        while (helperDeque.size() != 0 && operatorPrecedence.getPriority(Operators.getOperatorFromString(symbol))
                                <= operatorPrecedence.getPriority(Operators.getOperatorFromString(helperDeque.peekLast()))){
                            resultString.add(helperDeque.pollLast());
                        }helperDeque.addLast(symbol);
                    } else {
                        helperDeque.addLast(symbol);

                    }

                }

            }

        }

        while (helperDeque.size() > 0){
            resultString.add(helperDeque.pollLast());
        }

        return resultString.stream().toList();

    }

}


package StringsProcessing;

import Operators.Operators;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class StringValidationImpl implements StringValidation {

    private boolean noLetters (String string) throws Exception {
        String newString = string.replaceAll("[|a-zA-zа-яА-я!\"@#№$;%:^?&]", "").replaceAll("=", "");

        if (string.length() == newString.length()){
            return true;
        }throw new Exception("Присутствуют буквы");


    }
    private boolean bracketConsistency (String string) throws Exception {

        //Проверка на согласованность скобок при помощи стека
        Deque<String> stringDeque = new ArrayDeque<>();

        for (int i = 0; i < string.length(); i++){
            if (Character.toString(string.charAt(i)).equals(Operators.CLOSING_BRACKET.getString()) && stringDeque.peekLast() == null) {
                throw new Exception("Скобки не согласованны");
            }
            //Если встретили открывающую скобку, добавляем ее в стек
            if (Character.toString(string.charAt(i)).equals(Operators.OPEN_BRACKET.getString())){
                stringDeque.addLast(Operators.OPEN_BRACKET.getString());
            }
            //Если встретили закрывающую и при этом в стеке есть открывающая, открывающую их стека можно удалить
            if (Character.toString(string.charAt(i)).equals(Operators.CLOSING_BRACKET.getString()) &&
                    Objects.equals(stringDeque.peekLast(), Operators.OPEN_BRACKET.getString())){
                stringDeque.pollLast();
            }

        }
        //Если после завершения цикла последний элемент в стеке открывающая скобка - скобки не согласованны
        if (Objects.equals(stringDeque.peekLast(), Operators.OPEN_BRACKET.getString())){
            throw new Exception("Скобки не согласованны");

            //Если стек пустой - все отлично
        } else if (stringDeque.pollLast() == null) {
            return true;
        }

        return true;

    }
    private boolean checkBeginAndTheEnd (String stringWithoutSpaces) throws Exception {
        stringWithoutSpaces = stringWithoutSpaces.replaceAll("[()]", "");

        for (Operators operator : Operators.values()){
            if (stringWithoutSpaces.length() == 0){
                throw new Exception("Пустое выражение");
            }

            if(Character.toString(stringWithoutSpaces.charAt(0)).equals(operator.getString())){
                throw new Exception("Операторы не могут быть в начале или в конце");
            }

            if (Character.toString(stringWithoutSpaces.charAt(stringWithoutSpaces.length() - 1)).equals(operator.getString())) {
                throw new Exception("Операторы не могут быть в начале или в конце");
            }

        }

        return true;

    }

    @Override
    public boolean checkString(String string) throws Exception {

        string = string.replaceAll(" ", "");
        return noLetters(string) && bracketConsistency(string) && checkBeginAndTheEnd(string);

    }

}

import Calculation.FunctionMapImpl;
import Calculator.PostfixCalculator;
import Operators.OperatorPrecedenceImpl;
import StringsProcessing.ParsingString;
import StringsProcessing.StringValidationImpl;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        System.out.println("Введите выражение:");

        while (true){
            String expression = new Scanner(System.in).nextLine().toLowerCase().replaceAll(" ","");
            if (expression.equals("стоп") || expression.equals("stop")){
                System.out.println("Всего доброго!");
                break;
            }

            try {
                if (new StringValidationImpl().checkString(expression)){
                    double resultPostfix = new PostfixCalculator(new ParsingString(), new OperatorPrecedenceImpl(), new FunctionMapImpl())
                            .calculate(expression);
                    System.out.println("Результат постфиксного калькулятора: " + resultPostfix +
                            "\n Попробуйте еще раз или введите СТОП(STOP) для выхода:");
                }else {System.out.println(" Попробуйте еще раз или введите СТОП для выхода:");}
            }catch (Exception e){
                System.out.println("Ошибка: \"" + e.getMessage() + "\", попробуйте еще раз или введите СТОП(STOP) для выхода: ");
            }
        }
    }
}

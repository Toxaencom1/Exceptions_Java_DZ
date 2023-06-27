package DZ2;
/* Задача №2
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException с сообщением
"Деление на ноль недопустимо". В противном случае, программа должна выводить результат деления.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numberA, numberB;
        System.out.println("Hello user, this program divide two numbers!\n");
        try {
            System.out.print("Enter first number: ");
            numberA = scanner.nextDouble();
            System.out.print("Enter second number: ");
            numberB = scanner.nextDouble();
            if (numberB != 0) {
                System.out.printf(numberA % numberB == 0 ? "Result is: %.0f" : "Result is: %.3f", numberA / numberB);
            } else throw new DivisionByZeroException("You can`t divide by zero!");
        } catch (DivisionByZeroException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException ex) {
            System.err.println("Wrong input!");
        }finally {
            scanner.close();
        }
    }
}

class DivisionByZeroException extends Exception {
    DivisionByZeroException(String message) {
        super(message);
    }
}

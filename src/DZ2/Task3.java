package DZ2;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Задача №3
Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:

Если первое число больше 100, выбросить исключение NumberOutOfRangeException
с сообщением "Первое число вне допустимого диапазона".
Если второе число меньше 0, выбросить исключение NumberOutOfRangeException
с сообщением "Второе число вне допустимого диапазона".
Если сумма первого и второго чисел меньше 10,
выбросить исключение NumberSumException с сообщением "Сумма первого и второго чисел слишком мала".
Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
- необходимо создать 3 класса собственных исключений
 */
public class Task3 {
    public static void main(String[] args) {
        System.out.println("Hello user, This program check some conditions of three numbers!\n");
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        try {
            System.out.print("Enter first number: ");
            num1 = scanner.nextInt();
            if (num1 > 100) {
                throw new NumberOutOfRangeException("First number is out of range!");
            }
            System.out.print("Enter second number: ");
            num2 = scanner.nextInt();
            if (num2 < 0) {
                throw new NumberOutOfRangeException("Second number is out of range!");
            }
            if (num1 + num2 < 10) {
                throw new NumberSumException("Sum of first and second numbers is too low!");
            }
            System.out.print("Enter third number: ");
            num3 = scanner.nextInt();
            if (num3 == 0) {
                throw new DivisionByZeroException("You can`t divide by zero!");
            }
            System.out.println("Check passed successfully");
        } catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException ex) {
            System.err.println("Wrong input!");
        } finally {
            scanner.close();
        }
    }
}

class NumberOutOfRangeException extends Exception {
    NumberOutOfRangeException(String message) {
        super(message);
    }
}

class NumberSumException extends Exception {
    NumberSumException(String message) {
        super(message);
    }
}
// DivisionByZeroException Уже есть в этом Package

//class DivisionByZeroException extends Exception {
//    DivisionByZeroException(String message) {
//        super(message);
//    }
//}
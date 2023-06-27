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
        boolean flag = true;
        try {
            System.out.print("Enter first number: ");
            num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            num2 = scanner.nextInt();
            System.out.print("Enter third number: ");
            num3 = scanner.nextInt();
            try {
                checkNum1(num1);
            } catch (NumberOutOfRangeException e) {
                System.err.println("Error: " + e.getMessage());
                flag = false;
            }
            try {
                checkNum2(num2);
            } catch (NumberOutOfRangeException e) {
                System.err.println("Error: " + e.getMessage());
                flag = false;
            }
            try {
                checkSum(num1, num2);
            } catch (NumberSumException e) {
                System.err.println("Error: " + e.getMessage());
                flag = false;
            }
            try {
                checkDivide(num3);
            } catch (DivisionByZeroException e) {
                System.err.println("Error: " + e.getMessage());
                flag = false;
            }
        } catch (InputMismatchException ex) {
            System.err.println("Wrong input!");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Check passed successfully");
            }
            scanner.close();
        }
    }

    public static void checkNum1(int num) throws NumberOutOfRangeException {
        if (num > 100) {
            throw new NumberOutOfRangeException("First number is out of range!");
        }
    }

    public static void checkNum2(int num) throws NumberOutOfRangeException {
        if (num < 0) {
            throw new NumberOutOfRangeException("Second number is out of range!");
        }
    }

    public static void checkSum(int num1, int num2) throws NumberSumException {
        if (num1 + num2 < 10) {
            throw new NumberSumException("Sum of first and second numbers is too low!");
        }
    }

    public static void checkDivide(int num) throws DivisionByZeroException {
        if (num == 0) {
            throw new DivisionByZeroException("You can`t divide by zero!");
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
package DZ3;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.pow;

/* Задача №1
Напишите программу-калькулятор, которая запрашивает у пользователя два числа
и выполняет операцию возведения первого числа в степень второго числа.
Если введены некорректные числа или происходит деление на ноль, //====>????? В этой задаче деление не предусматривается
необходимо обработать соответствующие исключения и вывести информативное сообщение об ошибке.
Важно! С использованием принципа одного уровня абстракции!
**В этой задаче мы создаем класс PowerCalculator, который содержит метод calculatePower(),
выполняющий операцию возведения числа в степень. Если введено некорректное основание (ноль) и отрицательная степень,
выбрасывается исключение InvalidInputException.

В методе main() мы запрашиваем у пользователя основание и показатель степени, вызываем метод calculatePower()
и выводим результат. Если введены некорректные числа или происходит ошибка ввода,
соответствующие исключения перехватываются и выводится информативное сообщение об ошибке.

Обратите внимание, что в этой задаче мы использовали собственное исключение InvalidInputException,
чтобы явно указать на некорректный ввод. Это помогает разделить обработку ошибок на соответствующие уровни абстракции.**
 */
public class Task1 { // Класс PowerCalculator
    public static void main(String[] args) {
        int num, powGrade;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            num = scanner.nextInt();
            System.out.print(" and pow grade: ");
            powGrade = scanner.nextInt();
            System.out.println("Result is: " + calculatePower(num, powGrade));
        } catch (InvalidInputException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Wrong, you entered in not a number!");
        }
    }

    public static int calculatePower(int num, int powGrade) throws InvalidInputException {
        if (num == 0) {
            throw new InvalidInputException("Incorrect input! Number can`t be zero!");
        }
        if (powGrade < 0) {
            throw new InvalidInputException("Incorrect input! Grade can`t be less than zero");
        }
        int result = (int) pow(num, powGrade); // Can be long or double, but not necessary on this task
        if (result == 2147483647 || result == -2147483648) {
            throw new InvalidInputException("Incorrect input! Pow result is out of \"Int\" bounds");
        }
        return result;
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

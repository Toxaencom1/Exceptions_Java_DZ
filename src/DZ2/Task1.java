package DZ2;


import java.util.InputMismatchException;
import java.util.Scanner;

/* Задача №1
Напишите программу, которая запрашивает у пользователя число и проверяет,
является ли оно положительным. Если число отрицательное или равно нулю,
программа должна выбрасывать исключение InvalidNumberException с сообщением "Некорректное число".
В противном случае, программа должна выводить сообщение "Число корректно".
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Hello user, this program check you number on positivity!\n");
        System.out.print("Enter your number: ");
        try {
            number = scanner.nextInt();
            if (number <= 0) {
                throw new InvalidNumberException("Incorrect number");
            } else {
                System.out.println("Number is correct!");
            }
        } catch (InvalidNumberException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException ex){
            System.err.println("This not a number!");
        }finally {
            scanner.close();
        }
    }
}

class InvalidNumberException extends Exception {
    InvalidNumberException(String message) {
        super(message);
    }
}

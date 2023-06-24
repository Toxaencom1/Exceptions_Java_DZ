package DZ1;

/* Задача №1:  Проверка деления на ноль
Напишите программу, которая запрашивает у пользователя два целых числа и выполняет их деление.
Если второе число равно нулю, выбросите исключение ArithmeticException
с сообщением "Деление на ноль недопустимо". Иначе выведите результат деления на экран.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Hello user, this program show ArithmeticException by \"divide by zero\"\n" +
                "If you want exit type \"exit\"");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter the number: ");
            int a = validator.valInt(scanner.nextLine());
            System.out.print("Enter the next number: ");
            int b = validator.valInt(scanner.nextLine());
            int divide;
            try {
                divide = a/b;
                System.out.printf("    Divide result = %d\n", divide);
            }catch (ArithmeticException ex){
                System.out.println("    Division by zero is not allowed!\n");
            }
        }
    }
}

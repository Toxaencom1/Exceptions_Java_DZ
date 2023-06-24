package DZ1;

import java.util.Scanner;

/* Задача №1:  Обработка некорректного ввода
Напишите программу, которая запрашивает у пользователя его возраст.
Если введенное значение не является числом, выбросите исключение NumberFormatException с сообщением
"Некорректный ввод". Иначе выведите возраст на экран.
*/
public class Task2 {
    public static void main(String[] args) {
        System.out.println("Hello user, this program show NumberFormatException by \"Incorrect input!\"\n" +
                "If you want exit type \"exit\"");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter your age: ");
            int a = validator.valPosInt(scanner.nextLine()); // конструкция try/catch в классе validator
            System.out.printf("Thank you, your age is %d\n",a);
        }
    }
}

package DZ1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Задача №3: Чтение файла и подсчет суммы чисел
Напишите программу, которая считывает содержимое текстового файла,
в котором каждая строка содержит одно число. Программа должна подсчитать сумму всех чисел в файле.
Если встретится строка, которая не может быть преобразована в число,
выбросите исключение NumberFormatException с сообщением "Некорректное значение числа в файле".
 */
public class Task3 {
    public static int calculateSumFromFile(String fileName) {
        int sum = 0;
        int count = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    sum += number;
                } catch (NumberFormatException e) {
                    System.out.println("Error find!");
                    System.out.println("Incorrect number value in the file on line = " + count);
                }
                count++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello user, this program show NumberFormatException from reading file \n");
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("\\src\\DZ1\\Task3TXT.txt");
        int sum = calculateSumFromFile(pathFile);
        System.out.println("Sum of numbers in file: " + sum);
    }
}

package DZ1;

import java.util.Scanner;

public class validator {


    public static Integer valInt(String number) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                emergency_exit(number);
                if (Integer.parseInt(number) > -2_147_483_648 && Integer.parseInt(number) < 2_147_483_647) {//
                    return Integer.parseInt(number);
                } else {
                    System.out.print("Enter the - \"number\": ");
                    number = scanner.nextLine();
                }
            } catch (NumberFormatException ex) {
                System.out.print("Enter the - \"number\": ");
                number = scanner.nextLine();
            }
        }
    }
    public static Integer valPosInt(String number) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                emergency_exit(number);
                if (Integer.parseInt(number) >= 0 && Integer.parseInt(number) < 2_147_483_647) {//
                    return Integer.parseInt(number);
                } else {
                    System.out.print("    Incorrect input!\nEnter your age: ");
                    number = scanner.nextLine();
                }
            } catch (NumberFormatException ex) {
                System.out.print("    Incorrect input!\nEnter your age: ");
                number = scanner.nextLine();
            }
        }
    }

    public static String emergency_exit(String string) {
        if (string.equals("exit")) {
            System.exit(0);
        }
        return string;
    }
}

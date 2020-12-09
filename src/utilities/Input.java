package utilities;

import menus.Print;

import java.util.Scanner;

public class Input {
    private Print print = new Print();

    public static String fetchInputString(String message) {
        Print.print(message);
        Scanner input = new Scanner(System.in);
        String s="";
        do {
            s = input.nextLine();
        }while (s.equalsIgnoreCase(""));
        return s;
    }

    public static int fetchInputInt(String message) {
        int check=1;
        Print.print(message);
        Scanner input = new Scanner(System.in);
        int digit = 0;
        do{
            try {
                digit = input.nextInt();
            } catch (Exception e) {
                check = 1;
            } check=0;
        }while (check==1);
        return digit;
    }
}

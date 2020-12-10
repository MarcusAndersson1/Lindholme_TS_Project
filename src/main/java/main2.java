import CommandObserver.UserInput;
import controllers.Controller;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        System.out.println("kill me");
        System.out.println(" controller menu press 1 command line press 2");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        switch (choice) {
            case "1": {
                Controller controller = new Controller();
                controller.controllerMenu();
                break;
            }
            case "2": {
                while (true) {
                    System.out.println("create project: command createProject");
                    UserInput userInput = new UserInput();
                    String command = input.nextLine();
                    if (command.equalsIgnoreCase("stop")) {
                        break;
                    } else {
                        userInput.input(command);
                    }

                }

            }
        }
    }
}


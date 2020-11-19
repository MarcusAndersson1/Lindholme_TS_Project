import java.util.Scanner;

public class Input {
    private Print print = new Print();

    public String fetchInputString(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        return (input.nextLine());

    }

    public int fetchInputInt() {
        Scanner input = new Scanner(System.in);
        int digit;
        try {
            digit = input.nextInt();
        }catch(Exception e){
            return 0;
        }

        return digit;
    }

}

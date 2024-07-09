import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CommandHandler cmdHandler = new CommandHandler();
        cmdHandler.handle(input);
        System.out.println("Thanks for playing!");

    }
}

//MNEMONIC GUIDE:
//F: works fine
//E: error - weird shit going on
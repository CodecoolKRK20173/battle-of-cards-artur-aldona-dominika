import java.util.Scanner;

class Inputs {
    private Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
}


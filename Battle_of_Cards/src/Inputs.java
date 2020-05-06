import java.util.Scanner;

class Inputs {

    public void takeInput(String messageForUser) {
        Scanner input = new Scanner(System.in);
        System.out.println(messageForUser);
        input.nextLine();
    }
}


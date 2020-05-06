
import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Engine gameStart = new Engine();
        gameStart.start();
        View print = new View();
        print.printCards();
    }
}

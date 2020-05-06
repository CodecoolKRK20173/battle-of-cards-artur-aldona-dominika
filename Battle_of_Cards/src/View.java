import com.github.tomaslanger.chalk.Chalk;
import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.util.Arrays;

public class View {

    View() {

    }
    void printCards() {

        Card card1 = new Card("Zarroit", 10,10, 10, 10);
        Card card2 = new Card("Zaelliod", 20, 20, 20, 20);


        String card1Str = FlipTableConverters.fromIterable(Arrays.asList(card1), Card.class);
        String card2Str = FlipTableConverters.fromIterable(Arrays.asList(card2), Card.class);


        String headers[] = {"PLAYER 1"};
        String data[][] = {{Chalk.on(card1.toString()).cyan().toString()}};

        String headers1[] = {"PLAYER 2"};
        String data1[][] = {{Chalk.on(card2.toString()).cyan().toString()}};


        System.out.println(FlipTable.of(headers, data));
        System.out.println(FlipTable.of(headers1, data1));

    }
}
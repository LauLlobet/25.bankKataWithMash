import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Atm {
    private final Console console;
    private final Clock clock;
    private List<String> activity = new ArrayList<String>();
    public int accumulatedAmount =0;

    public Atm(Console console, Clock clock) {

        this.console = console;
        this.clock = clock;
    }

    public void printStatement() {
        console.println("date || credit || debit || balance");
        printStatementActivity();
    }

    private void printStatementActivity() {
        List<String> reverseActivity = new ArrayList<>(activity);
        Collections.reverse(reverseActivity);
        reverseActivity.forEach(transaction -> console.println(transaction));
    }

    public void deposit(int amount) {
        accumulatedAmount += amount;
        activity.add(clock.getDate() + " || " + amount + " || || " + accumulatedAmount);
    }
}

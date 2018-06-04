public class Atm {
    private final Console console;
    private final Clock clock;
    private String transaction;

    public Atm(Console console, Clock clock) {

        this.console = console;
        this.clock = clock;
    }

    public void printStatement() {
        console.println("date || credit || debit || balance");
        if(isDeposited()){
            printStatementActivity();

        }
    }

    private boolean isDeposited() {
        return transaction != null;
    }

    private void printStatementActivity() {
        console.println(transaction);
    }

    public void deposit(int amount) {
        transaction = clock.getDate()+" || "+amount+" || || "+amount;
    }
}

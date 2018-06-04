import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AtmMachineShould {

    @Mock
    Console console;
    @Mock
    private Clock clock;

    @Test
    public void
    print_header_when_no_account_activity() {
        Atm atm = new Atm(console, clock);

        atm.printStatement();

        verify(console).println("date || credit || debit || balance");
    }

    @Test
    public void
    print_a_single_deposit_activity() {
        Atm atm = new Atm(console, clock);
        
        given(clock.getDate()).willReturn("1/1/2001");
        atm.deposit(1000);
        given(clock.getDate()).willReturn("2/2/2002");
        atm.deposit(500);
        atm.printStatement();

        verify(console).println("date || credit || debit || balance");
        verify(console).println("2/2/2002 || 500 || || 1500");
        verify(console).println("1/1/2001 || 1000 || || 1000");
    }
}

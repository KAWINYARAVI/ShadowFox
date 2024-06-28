import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount bankAccount;

    @Before
    public void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(100.0);
        assertEquals(100.0, bankAccount.getBalance(), 0.001);
        List<String> history = bankAccount.getTransactionHistory();
        assertEquals(1, history.size());
        assertEquals("Deposited: $100.0", history.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        bankAccount.deposit(-50.0);
    }

    @Test
    public void testWithdraw() {
        bankAccount.deposit(100.0);
        bankAccount.withdraw(50.0);
        assertEquals(50.0, bankAccount.getBalance(), 0.001);
        List<String> history = bankAccount.getTransactionHistory();
        assertEquals(2, history.size());
        assertEquals("Withdrew: $50.0", history.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        bankAccount.withdraw(-50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawExceedingBalance() {
        bankAccount.deposit(50.0);
        bankAccount.withdraw(100.0);
    }

    @Test
    public void testTransactionHistory() {
        bankAccount.deposit(100.0);
        bankAccount.withdraw(50.0);
        List<String> history = bankAccount.getTransactionHistory();
        assertEquals(2, history.size());
        assertEquals("Deposited: $100.0", history.get(0));
        assertEquals("Withdrew: $50.0", history.get(1));
    }
}

package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.BankAccount;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("12345");
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(50.0);
        account.withdraw(100.0);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(100.0);
        account.withdraw(50.0);
        String expectedHistory = "Deposited: $100.0\nWithdrew: $50.0\n";
        assertEquals(expectedHistory, account.getTransactionHistory());
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }
}

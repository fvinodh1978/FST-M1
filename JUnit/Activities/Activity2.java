package activities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
    BankAccount ba;
    static int initialBalance=100;

    @BeforeEach
    public void initialiseBalance() {
        ba = new BankAccount();
        ba.initialise(initialBalance);
    }

    // Testcase to Test sunny day scenarios of withdrawal
    @ParameterizedTest
    @CsvSource({"100", "50"})
    public void testWithdrawal(int amount) {
        String actual = ba.withdraw(amount);
        int balance=initialBalance-amount;
        String expected = "Withdrawn " + amount + ", Balance : " + balance;
        assertEquals(expected, actual);
    }

    // Testcase with assertDoesn'tThrow
    @ParameterizedTest
    @CsvSource({"100"})
    public void testNoException(int amount){
        assertDoesNotThrow( ()->ba.withdraw(amount), "Sufficient Funds");
    }

    // Testcase to test throw Exception Scenario
    @ParameterizedTest
    @CsvSource({"150", "120"})
    public void testException(int amount) {
        assertThrows(InsufficientFundException.class, ()->ba.withdraw(amount), "Insufficient Funds");
    }
}

package br.com.pedropareschi;


import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass(){
        System.out.println("This executes before any instances. Count = " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Pedro", "de Melo", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600, true);
        assertEquals(400, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_notBranch() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600, false);
            fail("Should have thrown an IllegalArgumentException");
        });
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown(){
        System.out.println("Count = " + count++);
    }
}
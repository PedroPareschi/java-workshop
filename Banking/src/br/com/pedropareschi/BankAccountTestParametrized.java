package br.com.pedropareschi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountTestParametrized {

    private BankAccount account;

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Pedro","de Melo", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    void deposit(double amount, boolean branch, double expected){
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }

    public static Stream<Arguments> testConditions(){
        return Stream.of(
                Arguments.of( 100.00, true, 1100.00 ),
                Arguments.of( 200.00, true, 1200.00 ),
                Arguments.of( 325.14, true, 1325.14 ),
                Arguments.of( 489.33, true, 1489.33 ),
                Arguments.of( 1000.00, true, 2000.00 )
        );
    }
}

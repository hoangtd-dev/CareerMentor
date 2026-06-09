package models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

@DisplayName("NABBankCard")
public class NABBankCardTest {

    private NABBankCard card;

    @BeforeEach
    void init() {
        card = new NABBankCard("1234567890", new BigDecimal("1000"), "user-1", "John Doe");
    }

    @Test
    @DisplayName("deposit should return false when amount is below minimum $10")
    void deposit_returnFalse_whenAmountBelowMinimumTen() {
        BigDecimal originalBalance = card.getBalance();
        boolean result = card.deposit(new BigDecimal("9.99"));
        assertFalse(result);
        assertEquals(originalBalance, card.getBalance());
    }

    @Test
    @DisplayName("deposit should return true and increase balance when amount is at minimum $10")
    void deposit_returnTrue_andIncreaseBalance_whenAmountAtMinimumTen() {
        boolean result = card.deposit(new BigDecimal("10"));
        assertTrue(result);
        assertEquals(new BigDecimal("1010"), card.getBalance());
    }

    @Test
    @DisplayName("withdraw should return false when amount exceeds limit $2000")
    void withdraw_returnFalse_whenAmountExceedsLimitTwoThousand() {
        BigDecimal originalBalance = card.getBalance();
        boolean result = card.withdraw(new BigDecimal("2001"));
        assertFalse(result);
        assertEquals(originalBalance, card.getBalance());
    }

    @Test
    @DisplayName("withdraw should return false when remaining balance would drop below $20")
    void withdraw_returnFalse_whenRemainingBalanceBelowTwenty() {
        BigDecimal originalBalance = card.getBalance();
        boolean result = card.withdraw(new BigDecimal("981"));
        assertFalse(result);
        assertEquals(originalBalance, card.getBalance());
    }

    @Test
    @DisplayName("withdraw should return true and decrease balance when amount is valid")
    void withdraw_returnTrue_andDecreaseBalance_whenValidAmount() {
        boolean result = card.withdraw(new BigDecimal("500"));
        assertTrue(result);
        assertEquals(new BigDecimal("500"), card.getBalance());
    }

    @Test
    @DisplayName("getBalanceMessage should return message with fullname and balance")
    void getBalanceMessage_returnCorrectFormatWithFullname() {
        String message = card.getBalanceMessage();
        assertEquals("Hi John Doe, your card balance on NAB bank is 1000", message);
    }

    @Test
    @DisplayName("numberOfTransactionDisplayed should return 10 for NAB")
    void numberOfTransactionDisplayed_returnTen() {
        assertEquals(10, card.numberOfTransactionDisplayed());
    }
}

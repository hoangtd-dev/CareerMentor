package models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

@DisplayName("CMWBankCard")
public class CMWBankCardTest {

    private CMWBankCard card;

    @BeforeEach
    void init() {
        card = new CMWBankCard("1234567890", new BigDecimal("1000"), "user-1", "John Doe");
    }

    @Test
    @DisplayName("deposit should return false when amount is below minimum $5")
    void deposit_returnFalse_whenAmountBelowMinimumFive() {
        BigDecimal originalBalance = card.getBalance();
        boolean result = card.deposit(new BigDecimal("4.99"));
        assertFalse(result);
        assertEquals(originalBalance, card.getBalance());
    }

    @Test
    @DisplayName("deposit should return true and increase balance when amount is at minimum $5")
    void deposit_returnTrue_andIncreaseBalance_whenAmountAtMinimumFive() {
        boolean result = card.deposit(new BigDecimal("5"));
        assertTrue(result);
        assertEquals(new BigDecimal("1005"), card.getBalance());
    }

    @Test
    @DisplayName("withdraw should return false when amount exceeds limit $3000")
    void withdraw_returnFalse_whenAmountExceedsLimitThreeThousand() {
        BigDecimal originalBalance = card.getBalance();
        boolean result = card.withdraw(new BigDecimal("3001"));
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
    @DisplayName("getBalanceMessage should return message with masked card number and balance")
    void getBalanceMessage_returnCorrectFormatWithMaskedCardNumber() {
        String message = card.getBalanceMessage();
        assertEquals("CMW bank account with number ******67890 has balance is 1000", message);
    }

    @Test
    @DisplayName("numberOfTransactionDisplayed should throw UnsupportedOperationException")
    void numberOfTransactionDisplayed_throwUnsupportedException() {
        assertThrows(UnsupportedOperationException.class, () -> card.numberOfTransactionDisplayed());
    }
}

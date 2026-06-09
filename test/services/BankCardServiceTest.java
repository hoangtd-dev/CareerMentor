package services;

import interfaces.IRepository;
import models.User;
import models.base.BankCard;
import models.Transaction;
import enums.BankEnum;
import enums.TransactionTypeEnum;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

@DisplayName("BankCardService")
public class BankCardServiceTest {

    private FakeBankCardRepository fakeBankCardRepo;
    private FakeTransactionRepository fakeTransactionRepo;
    private AuthService authService;
    private TransactionService transactionService;
    private BankCardService bankCardService;

    @BeforeEach
    void init() {
        fakeBankCardRepo = new FakeBankCardRepository();
        fakeTransactionRepo = new FakeTransactionRepository();

        authService = new AuthService(new FakeUserRepository());
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        authService.login("john", "pass");

        transactionService = new TransactionService(fakeTransactionRepo);
        bankCardService = new BankCardService(fakeBankCardRepo, transactionService, authService);
    }

    @Test
    @DisplayName("registerNewCard should return true when card number does not exist")
    void registerNewCard_returnTrue_whenCardNumberNotExisted() {
        boolean result = bankCardService.registerNewCard(BankEnum.ANZ, "1234567890", new BigDecimal("1000"));
        assertTrue(result);
    }

    @Test
    @DisplayName("registerNewCard should return false when card number already exists")
    void registerNewCard_returnFalse_whenCardNumberAlreadyExisted() {
        bankCardService.registerNewCard(BankEnum.ANZ, "1234567890", new BigDecimal("1000"));
        boolean result = bankCardService.registerNewCard(BankEnum.NAB, "1234567890", new BigDecimal("500"));
        assertFalse(result);
    }

    @Test
    @DisplayName("deposit should throw IllegalArgumentException when amount is below bank minimum")
    void deposit_throwException_whenAmountBelowMinimum() {
        bankCardService.registerNewCard(BankEnum.ANZ, "1234567890", new BigDecimal("1000"));
        assertThrows(IllegalArgumentException.class, () -> bankCardService.deposit(new BigDecimal("9")));
    }

    @Test
    @DisplayName("deposit should save card and create transaction when amount is valid")
    void deposit_saveCardAndCreateTransaction_whenValidAmount() {
        bankCardService.registerNewCard(BankEnum.ANZ, "1234567890", new BigDecimal("1000"));
        bankCardService.deposit(new BigDecimal("100"));
        assertEquals(1, fakeTransactionRepo.data.size());
        assertEquals(TransactionTypeEnum.Deposit, fakeTransactionRepo.data.get(0).getType());
    }

    @Test
    @DisplayName("withdraw should throw IllegalArgumentException when amount exceeds bank limit")
    void withdraw_throwException_whenAmountExceedsLimit() {
        bankCardService.registerNewCard(BankEnum.ANZ, "1234567890", new BigDecimal("1000"));
        assertThrows(IllegalArgumentException.class, () -> bankCardService.withdraw(new BigDecimal("1001")));
    }

    @Test
    @DisplayName("withdraw should save card and create transaction when amount is valid")
    void withdraw_saveCardAndCreateTransaction_whenValidAmount() {
        bankCardService.registerNewCard(BankEnum.ANZ, "1234567890", new BigDecimal("1000"));
        bankCardService.withdraw(new BigDecimal("500"));
        assertEquals(1, fakeTransactionRepo.data.size());
        assertEquals(TransactionTypeEnum.Withdraw, fakeTransactionRepo.data.get(0).getType());
    }

    @Test
    @DisplayName("hasCard should return true when current user has a registered card")
    void hasCard_returnTrue_whenUserHasCard() {
        bankCardService.registerNewCard(BankEnum.ANZ, "1234567890", new BigDecimal("1000"));
        assertTrue(bankCardService.hasCard());
    }

    @Test
    @DisplayName("hasCard should return false when current user has no card")
    void hasCard_returnFalse_whenUserHasNoCard() {
        assertFalse(bankCardService.hasCard());
    }

    @Test
    @DisplayName("getBalanceMessage should return balance message from current card")
    void getBalanceMessage_returnMessageFromCurrentCard() {
        bankCardService.registerNewCard(BankEnum.NAB, "1234567890", new BigDecimal("500"));
        String message = bankCardService.getBalanceMessage();
        assertTrue(message.contains("500"));
        assertTrue(message.contains("NAB"));
    }

    private static class FakeUserRepository implements IRepository<User> {
        private ArrayList<User> data = new ArrayList<>();
        @Override public void save(ArrayList<User> d) { this.data = new ArrayList<>(d); }
        @Override public ArrayList<User> load() { return new ArrayList<>(data); }
    }

    private static class FakeBankCardRepository implements IRepository<BankCard> {
        private ArrayList<BankCard> data = new ArrayList<>();
        @Override public void save(ArrayList<BankCard> d) { this.data = new ArrayList<>(d); }
        @Override public ArrayList<BankCard> load() { return new ArrayList<>(data); }
    }

    private static class FakeTransactionRepository implements IRepository<Transaction> {
        ArrayList<Transaction> data = new ArrayList<>();
        @Override public void save(ArrayList<Transaction> d) { this.data = new ArrayList<>(d); }
        @Override public ArrayList<Transaction> load() { return new ArrayList<>(data); }
    }
}

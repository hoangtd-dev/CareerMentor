package services;

import interfaces.IRepository;
import models.Transaction;
import org.junit.jupiter.api.*;
import enums.TransactionTypeEnum;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DisplayName("TransactionService")
public class TransactionServiceTest {

    private FakeTransactionRepository fakeRepo;
    private TransactionService transactionService;

    @BeforeEach
    void init() {
        fakeRepo = new FakeTransactionRepository();

        List<Transaction> seed = new ArrayList<>();
        seed.add(new Transaction(TransactionTypeEnum.Deposit, new BigDecimal("100"), "card-001"));
        seed.add(new Transaction(TransactionTypeEnum.Withdraw, new BigDecimal("50"), "card-001"));
        seed.add(new Transaction(TransactionTypeEnum.Deposit, new BigDecimal("200"), "card-001"));
        seed.add(new Transaction(TransactionTypeEnum.Deposit, new BigDecimal("300"), "card-002"));
        seed.add(new Transaction(TransactionTypeEnum.Withdraw, new BigDecimal("100"), "card-002"));
        fakeRepo.save(seed);

        transactionService = new TransactionService(fakeRepo);
    }

    @Test
    @DisplayName("getTransactionsByCardNumber should return only transactions matching the given card number")
    void getTransactionsByCardNumber_returnFilteredList_whenCardNumberMatches() {
        List<Transaction> result = transactionService.getTransactionsByCardNumber(fakeRepo.load(), "card-001");
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(t -> t.getCardNumber().equals("card-001")));
    }

    @Test
    @DisplayName("getTransactionHistory should return the last N transactions for the given card number")
    void getTransactionHistory_returnLastNTransactions() {
        // card-001 has 3 transactions: Deposit100, Withdraw50, Deposit200
        // last 2 should be: Withdraw50, Deposit200
        List<Transaction> result = transactionService.getTransactionHistory("card-001", 2);
        assertEquals(2, result.size());
        assertEquals(new BigDecimal("50"), result.get(0).getAmount());
        assertEquals(new BigDecimal("200"), result.get(1).getAmount());
    }

    @Test
    @DisplayName("getTransactionHistory should return all transactions when take exceeds total count")
    void getTransactionHistory_returnAll_whenTakeExceedsTotalCount() {
        List<Transaction> result = transactionService.getTransactionHistory("card-001", 100);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("createTransaction should add new transaction to the repository")
    void createTransaction_addNewTransactionToRepository() {
        transactionService.createTransaction(TransactionTypeEnum.Deposit, new BigDecimal("150"), "card-001");
        assertEquals(6, fakeRepo.data.size());
        assertEquals(TransactionTypeEnum.Deposit, fakeRepo.data.get(5).getType());
        assertEquals(new BigDecimal("150"), fakeRepo.data.get(5).getAmount());
    }

    private static class FakeTransactionRepository implements IRepository<Transaction> {
        List<Transaction> data = new ArrayList<>();
        @Override public void save(List<Transaction> d) { this.data = new ArrayList<>(d); }
        @Override public List<Transaction> load() { return new ArrayList<>(data); }
    }
}

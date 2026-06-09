package repositories;

import models.Transaction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import enums.TransactionTypeEnum;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;

@DisplayName("TransactionRepository")
public class TransactionRepositoryTest {

    @TempDir
    Path tempDir;

    private TransactionRepository repository;

    @BeforeEach
    void init() {
        repository = new TransactionRepository(tempDir.resolve("transactions.txt").toString());
    }

    @Test
    @DisplayName("load should return empty list when file is empty")
    void load_returnEmptyList_whenFileIsEmpty() {
        ArrayList<Transaction> result = repository.load();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("save and load should return original data after saving")
    void saveAndLoad_returnOriginalData_whenDataIsSaved() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(TransactionTypeEnum.Deposit, new BigDecimal("100.00"), "1234567890"));

        repository.save(transactions);
        ArrayList<Transaction> loaded = repository.load();

        assertEquals(1, loaded.size());
        assertEquals(TransactionTypeEnum.Deposit, loaded.get(0).getType());
        assertEquals(new BigDecimal("100.00"), loaded.get(0).getAmount());
        assertEquals("1234567890", loaded.get(0).getCardNumber());
    }
}

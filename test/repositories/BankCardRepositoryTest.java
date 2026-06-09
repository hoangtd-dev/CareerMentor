package repositories;

import models.base.BankCard;
import models.ANZBankCard;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import enums.BankEnum;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;

@DisplayName("BankCardRepository")
public class BankCardRepositoryTest {

    @TempDir
    Path tempDir;

    private BankCardRepository repository;

    @BeforeEach
    void init() {
        repository = new BankCardRepository(tempDir.resolve("cards.txt").toString());
    }

    @Test
    @DisplayName("load should return empty list when file is empty")
    void load_returnEmptyList_whenFileIsEmpty() {
        ArrayList<BankCard> result = repository.load();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("save and load should return original data after saving")
    void saveAndLoad_returnOriginalData_whenDataIsSaved() {
        ArrayList<BankCard> cards = new ArrayList<>();
        cards.add(new ANZBankCard("1234567890", new BigDecimal("500.00"), "user-1", "John Doe"));

        repository.save(cards);
        ArrayList<BankCard> loaded = repository.load();

        assertEquals(1, loaded.size());
        assertEquals(BankEnum.ANZ, loaded.get(0).getBankName());
        assertEquals("1234567890", loaded.get(0).getCardNumber());
        assertEquals(new BigDecimal("500.00"), loaded.get(0).getBalance());
    }
}

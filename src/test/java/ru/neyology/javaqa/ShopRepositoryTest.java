package ru.neyology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product item1 = new Product(12, "тест1", 23);
    Product item2 = new Product(24, "тест2", 64);
    Product item3 = new Product(36, "тест3", 87);

    @Test
    public void FalseNotFoundExceptionTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-100);
        });
    }

    @Test
    public void TrueFalseNotFoundExceptionTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.remove(24);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}

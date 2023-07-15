import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "хлеб", 50);
    Product product2 = new Product(2, "фонарь", 2000);
    Product product3 = new Product(3, "батарейки", 150);
    Product product4 = new Product(4, "шоколодка", 80);
    Product product5 = new Product(5, "поднос", 300);

    @Test
    public void shouldFindAll() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);


        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindZero() {

        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOne() {
        repo.add(product1);

        Product[] expected = {product1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemove() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        repo.remove(3);

        Product[] expected = {product1, product2, product4, product5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNonexistent() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(7);
        });
    }

    @Test
    public void shouldAddElementExisting() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product2);
        });
    }

}


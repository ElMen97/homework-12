package ProductManager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(10, "Плюшевый мишка", 500);
        Product product2 = new Product(302, "Автомобиль", 2_000_000);
        Product product3 = new Product(504, "Смартфон", 30_000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(302);
        Product[] actual = shopRepository.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(10, "Плюшевый мишка", 500);
        Product product2 = new Product(302, "Автомобиль", 2_000_000);
        Product product3 = new Product(504, "Смартфон", 30_000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(15)
        );
    }
}

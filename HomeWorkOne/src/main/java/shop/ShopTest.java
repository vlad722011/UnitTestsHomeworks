package shop;

import java.util.ArrayList;
import java.util.List;
import java.lang.AssertionError;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
   (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
   (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        // Создаем несколько экземпляров класса Product
        Product xiaomiTV = new Product();
        xiaomiTV.setTitle("Телевизор Xiaomi Mi");
        xiaomiTV.setCost(24990);

        Product xSmartTV = new Product();
        xSmartTV.setTitle("Телевизор HAIER Smart TV");
        xSmartTV.setCost(29590);

        Product tclTV = new Product();
        tclTV.setTitle("Телевизор TCL");
        tclTV.setCost(59990);

        Product samsungTV = new Product();
        samsungTV.setTitle("Телевизор Samsung");
        samsungTV.setCost(41990);

        // Создадим список товаров, состоящий из созданных экземпляров класса Product
        List<Product> productsForShop = new ArrayList<Product>();
        productsForShop.add(xiaomiTV);
        productsForShop.add(xSmartTV);
        productsForShop.add(tclTV);
        productsForShop.add(samsungTV);
        productsForShop.add(xiaomiTV);
        productsForShop.add(tclTV);
        productsForShop.add(xiaomiTV);


        // Создадим список товаров магазина отсортированный по цене руками, для последующей проверки
        // корректности метода sortProductsByPrice
        List<Product> sortedListForTestOne = new ArrayList<Product>();
        sortedListForTestOne.add(xiaomiTV);
        sortedListForTestOne.add(xiaomiTV);
        sortedListForTestOne.add(xiaomiTV);
        sortedListForTestOne.add(xSmartTV);
        sortedListForTestOne.add(samsungTV);
        sortedListForTestOne.add(tclTV);
        sortedListForTestOne.add(tclTV);


        // Создадим экземпляр класса Shop
        Shop shop = new Shop();

        // Задаем список товаров у созданного экземпляра Shop
        shop.setProducts(productsForShop);

        // Получаем список товаров у созданного экземпляра Shop
        List<Product> shopProductsList = shop.getProducts();


        // 1. Проверяем, что магазин хранит верный список продуктов (правильное количество продуктов,
        // верное содержимое корзины)
        try {
            assertThat(shopProductsList).isEqualTo(productsForShop);
        } catch (AssertionError e) {
            throw new AssertionError("Магазин хранит неверный список товаров");
        }


        // 2. Тест для проверки корректности работы метода getMostExpensiveProduct.
        // (проверьте правильность возврата самого дорогого продукта).

        // 2.1 Корректная отработка метода:
        try {
            for (int i = 0; i < productsForShop.size(); i++) {
                assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(59990);
                assertThat(shop.getMostExpensiveProduct().getTitle()).isEqualTo("Телевизор TCL");
            }
        } catch (AssertionError e) {
            throw new AssertionError("Ошибка метода поиска самого дорогого товара");
        }

        // 2.2 Некорректная отработка метода:
        // Раскомментируйте соответствующий блок кода для воспроизведения теста (строки 94-104)
        /*
        try {
            for (int i = 0; i < productsForShop.size(); i++) {
                assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(24990);
                assertThat(shop.getMostExpensiveProduct().getTitle()).isEqualTo("Телевизор Xiaomi Mi");
            }

        } catch (AssertionError e) {
            throw new AssertionError("Ошибка метода поиска самого дорогого товара");
        }
         */


        // 3. Тест для проверки корректности работы метода sortProductsByPrice
        // (проверьте правильность сортировки).
        // 3.1 Корректная отработка метода:

        try {
            for (int i = 0; i < sortedListForTestOne.size(); i++) {
                assertThat(shop.sortProductsByPrice().get(i).getCost()).isEqualTo(sortedListForTestOne.get(i).getCost());
                assertThat(shop.sortProductsByPrice().get(i).getTitle()).isEqualTo(sortedListForTestOne.get(i).getTitle());
            }
        } catch (AssertionError e) {
            throw new AssertionError("Ошибка метода сортировки по цене");
        }


        // 3.2 Некорректная отработка метода:
        // Создадим руками неправильно отсортированный массив, чтобы воспроизвести негативный сценарий
        // Раскомментируйте соответствующий блок кода для воспроизведения теста (строки 125-139)
        /*
        List<Product> listForTestTwo = new ArrayList<>();
        listForTestTwo = sortedListForTestOne;
        // Удалим один элемент из списка товаров, чтобы воспроизвести ошибку в тесте
        listForTestTwo.remove(3);

        try {
            for (int i = 0; i < listForTestTwo.size(); i++) {
                assertThat(shop.sortProductsByPrice().get(i).getCost()).isEqualTo(listForTestTwo.get(i).getCost());
                assertThat(shop.sortProductsByPrice().get(i).getTitle()).isEqualTo(listForTestTwo.get(i).getTitle());
            }
        } catch (AssertionError e) {
            throw new AssertionError("Ошибка метода сортировки по цене");
        }
        */
    }
}

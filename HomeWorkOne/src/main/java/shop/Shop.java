package shop;

import java.util.*;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        List<Product> list = products;
        List<Integer> prices = new ArrayList<>();
        HashMap<Integer, String> mapsProducts = new HashMap<>();
        for (Product p : list) {
            Product product = new Product();
            String title = p.getTitle();
            int cost = p.getCost();
            mapsProducts.put(cost, title);
            prices.add(cost);
        }
        Collections.sort(prices);
        List<Product> sortedProductsByPrice = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = new Product();
            int cost = prices.get(i);
            String title = mapsProducts.get(cost);
            product.setCost(prices.get(i));
            product.setTitle(title);
            sortedProductsByPrice.add(product);
        }
        return sortedProductsByPrice;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        List<Product> list = products;
        int maxCost = 0;
        Product product = new Product();
        for (Product p : list) {
            String title = p.getTitle();
            int cost = p.getCost();
            if (cost > maxCost) {
                maxCost = cost;
                product.setCost(maxCost);
                product.setTitle(title);
            }
        }
        return product;
    }
}
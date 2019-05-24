package ru.itpark.ulmart.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.ulmart.domain.Product;

@Repository
public class ProductRepository {
    private Product[] items = new Product[10];
    private int nextIndex = 0;

    public Product[] getAll() {
        return items;
    }

    public Product getById(int id) {
        for (Product item : items) {
            if (item != null && item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void add(Product product) {
        items[nextIndex] = product;
        nextIndex++;
    }

    public void updateById(Product product) {
        for (int i = 0; i < items.length; i++) {
            Product item = items[i];
            if (item != null && item.getId() == product.getId()) {
                items[i] = product;
                return;
            }
        }
    }

    public void removeById(int id) {
        for (int i = 0; i < items.length; i++) {
            Product item = items[i];
            if (item != null && item.getId() == id) {
                items[i] = null;
                return;
            }
        }
    }
}

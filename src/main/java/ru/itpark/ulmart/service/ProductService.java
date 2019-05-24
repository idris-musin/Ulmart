package ru.itpark.ulmart.service;

import org.springframework.stereotype.Service;
import ru.itpark.ulmart.domain.Electrolux;
import ru.itpark.ulmart.domain.IPhone;
import ru.itpark.ulmart.domain.Product;
import ru.itpark.ulmart.domain.TShirt;
import ru.itpark.ulmart.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;
    private int nextId = 1;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] getAll() {
        return repository.getAll();
    }

    public Product[] searchByName(String search) {
        int maxResult = 10;
        Product[] result = new Product[maxResult];
        int nextIndex = 0;

        for (Product product : repository.getAll()) {
            if (product == null) {
                continue;
            }

            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                result[nextIndex] = product;
                nextIndex++;
            }

            if (nextIndex == maxResult) {
                break;
            }
        }

        return result;
    }

    public Product getById(int id) {
        return repository.getById(id);
    }

    public void add(String name, int price, String os, String model, String color, int memorySize) {
        IPhone phone = new IPhone(nextId, name, price, os, model, color, memorySize);
        repository.add(phone);
        nextId++;
    }

    public void add(String name, int price, int size, String color) {
        TShirt shirt = new TShirt(nextId, name, price, size, color);
        repository.add(shirt);
        nextId++;
    }

    public void add(String name, int price, String type, int ovenVolume, int width, int depth, int height) {
        Electrolux electrolux = new Electrolux(nextId, name, price, type, ovenVolume, width, depth, height);
        repository.add(electrolux);
        nextId++;
    }

    public void updateById(int id, String name, int price, String os, String model, String color, int memorySize) {
        IPhone phone = new IPhone(id, name, price, os, model, color, memorySize);
        repository.updateById(phone);
    }

    public void updateById(int id, String name, int price, int size, String color) {
        TShirt shirt = new TShirt(id, name, price, size, color);
        repository.updateById(shirt);
    }

    public void updateById(int id, String name, int price, String type, int ovenVolume, int width, int depth, int height) {
        Electrolux electrolux = new Electrolux(id, name, price, type, ovenVolume, width, depth, height);
        repository.updateById(electrolux);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}

package com.repositoy;

import com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository{

    private static Map<Integer, Product> productMap;
    private static List<String> nameProductList = new ArrayList<>();

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Tivi", 1000.0, "Sony 4K 55 in", "Sony"));
        productMap.put(2, new Product(2, "Điện thoại", 900.0, "Iphone 13 pro", "Iphone"));
        productMap.put(3, new Product(3, "Điện thoại", 730.0, "Samsung Note 20", "Samsung"));

        nameProductList.add("Tivi");
        nameProductList.add("Điện thoại");
        nameProductList.add("Tủ lạnh");
        nameProductList.add("Máy giặt");

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<String> findNameProduct() {
        return nameProductList;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>(productMap.values());
//        Tạo 1 list rỗng để hứng giá trị name sau khi search ra
        List<Product> products = new ArrayList<>();
        for (Product product: productList) {
            if (product.getNameProduct().contains(name)) {
                products.add(product);
            }
        }

        return products;
    }
}

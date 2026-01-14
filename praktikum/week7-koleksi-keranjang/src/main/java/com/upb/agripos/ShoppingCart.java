package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    // Menyimpan daftar produk menggunakan ArrayList
    private final ArrayList<Product> items = new ArrayList<>();

    // Perhatikan nama method ini: addProduct (bukan addProduk)
    public void addProduct(Product p) { 
        items.add(p); 
    }

    // Perhatikan nama method ini: removeProduct (bukan removeProduk)
    public void removeProduct(Product p) { 
        items.remove(p); 
    }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
        System.out.println("-------------------------");
    }
}
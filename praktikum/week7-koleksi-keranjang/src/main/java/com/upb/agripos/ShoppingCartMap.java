package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    // Key = Product, Value = Integer (Jumlah/Quantity)
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) {
        // Cek jika barang sudah ada, tambah jumlahnya +1. Jika belum, set jadi 1.
        items.put(p, items.getOrDefault(p, 0) + 1);
    }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        
        int qty = items.get(p);
        if (qty > 1) {
            // Jika jumlah lebih dari 1, kurangi 1
            items.put(p, qty - 1);
        } else {
            // Jika jumlah sisa 1, hapus barang dari keranjang
            items.remove(p);
        }
    }

    public double getTotal() {
        double total = 0;
        // Loop setiap entry di Map untuk hitung (Harga x Jumlah)
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
        System.out.println("-------------------------");
    }
}
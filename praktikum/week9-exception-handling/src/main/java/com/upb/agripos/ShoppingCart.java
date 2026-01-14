package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();

    // Menambah produk dengan validasi jumlah (Exception)
    public void addProduct(Product p, int qty) throws InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity harus lebih dari 0.");
        }
        items.put(p, items.getOrDefault(p, 0) + qty);
    }

    // Menghapus produk dengan validasi keberadaan (Exception)
    public void removeProduct(Product p) throws ProductNotFoundException {
        if (!items.containsKey(p)) {
            throw new ProductNotFoundException("Produk tidak ada dalam keranjang.");
        }
        items.remove(p);
    }

    // Checkout dengan validasi stok (Exception)
    public void checkout() throws InsufficientStockException {
        // Cek stok dulu sebelum mengurangi
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            
            if (product.getStock() < qty) {
                throw new InsufficientStockException(
                    "Stok tidak cukup untuk: " + product.getName() + " (Sisa: " + product.getStock() + ")"
                );
            }
        }
        
        // Jika semua aman, kurangi stok
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }
        System.out.println("Checkout berhasil! Stok telah diperbarui.");
    }
}
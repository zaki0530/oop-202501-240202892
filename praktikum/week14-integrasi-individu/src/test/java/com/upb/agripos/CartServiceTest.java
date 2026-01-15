package com.upb.agripos;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ValidationException;

public class CartServiceTest {
    public static void main(String[] args) {
        System.out.println("=== UNIT TEST: CartService ===");
        CartService cart = new CartService();
        Product p1 = new Product("T01", "Test Item", 10000, 50);

        try {
            // Test 1: Hitung Total
            cart.addItem(p1, 2);
            if (cart.getTotal() == 20000) {
                System.out.println("[PASS] Perhitungan Total Benar.");
            } else {
                System.out.println("[FAIL] Total Salah!");
            }

            // Test 2: Cek Validasi Stok
            try {
                cart.addItem(p1, 100); // Stok cuma 50
                System.out.println("[FAIL] Validasi Stok Gagal (Harusnya Error)");
            } catch (ValidationException e) {
                System.out.println("[PASS] Validasi Stok Berjalan: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
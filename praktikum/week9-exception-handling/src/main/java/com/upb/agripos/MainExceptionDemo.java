package com.upb.agripos;


public class MainExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Hello, I am [Abu Zaki]-[240202892] (Week9)");
        System.out.println("==========================================");

        ShoppingCart cart = new ShoppingCart();
        
        // Pastikan Product.java di folder model sudah versi Week 9 (ada price & stock)
        // Product(code, name, price, stock)
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 3);

        // Kasus 1: Menambah jumlah invalid (Minus)
        System.out.println("\n1. Test Invalid Quantity:");
        try {
            cart.addProduct(p1, -1);
        } catch (InvalidQuantityException e) {
            System.err.println("Gagal: " + e.getMessage());
        }

        // Kasus 2: Menghapus produk yang belum ada
        System.out.println("\n2. Test Product Not Found:");
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.err.println("Gagal: " + e.getMessage());
        }

        // Kasus 3: Checkout melebihi stok (Stok cuma 3, beli 5)
        System.out.println("\n3. Test Insufficient Stock:");
        try {
            cart.addProduct(p1, 5); // Beli 5
            cart.checkout();
        } catch (Exception e) {
            System.err.println("Gagal: " + e.getMessage());
        }
    }
}
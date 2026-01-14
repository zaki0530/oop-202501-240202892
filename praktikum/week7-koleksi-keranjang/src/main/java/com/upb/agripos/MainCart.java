package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        // GANTI [Nama]-[NIM] dengan data asli Anda
        System.out.println("Hello, I am [Abu Zaki]-[240202892] (Week7)");
        System.out.println("==========================================");

        // Pastikan nama class-nya Product (sesuai nama file Product.java)
        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        ShoppingCart cart = new ShoppingCart();

        // PENTING: Gunakan addProduct (sesuai yang ada di ShoppingCart.java)
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        // PENTING: Gunakan removeProduct
        cart.removeProduct(p1);
        cart.printCart();
    }
}
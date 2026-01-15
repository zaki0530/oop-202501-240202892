package com.upb.agripos.service;

import com.upb.agripos.model.Cart;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;
import java.util.List;

public class CartService {
    private Cart cart = new Cart();

    public void addItem(Product product, int qty) throws ValidationException {
        if (qty <= 0) throw new ValidationException("Qty harus lebih dari 0");
        if (qty > product.getStock()) throw new ValidationException("Stok tidak cukup! Sisa: " + product.getStock());

        cart.addItem(new CartItem(product, qty));
    }

    public List<CartItem> getItems() { return cart.getItems(); }
    public double getTotal() { return cart.calculateGrandTotal(); }
    public void clearCart() { cart.clear(); }
}
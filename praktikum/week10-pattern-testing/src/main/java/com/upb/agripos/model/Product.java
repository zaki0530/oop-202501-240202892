package com.upb.agripos.model;

public class Product {
    private final String code;
    private final String name;
    // Hapus variable price

    // Constructor ini HANYA menerima 2 parameter (sesuai AppMVC)
    public Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}
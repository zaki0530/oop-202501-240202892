package com.upb.agripos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.upb.agripos.model.Product;

public class ProductTest {

    @Test
    public void testProductName() {
        // Skenario: Membuat produk baru
        Product p = new Product("P01", "Benih Jagung");
        
        // Verifikasi: Apakah nama yang tersimpan sesuai harapan?
        assertEquals("Benih Jagung", p.getName());
    }

    @Test
    public void testProductCode() {
        Product p = new Product("P99", "Obat Hama");
        assertEquals("P99", p.getCode());
    }
}
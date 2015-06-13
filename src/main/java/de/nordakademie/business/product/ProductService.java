package de.nordakademie.business.product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(final String color, final String ps);
}

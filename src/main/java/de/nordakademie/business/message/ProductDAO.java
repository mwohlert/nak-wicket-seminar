package de.nordakademie.business.message;

import java.util.List;

public interface ProductDAO {

    List<Product> findAll(final String color, final String ps);
}

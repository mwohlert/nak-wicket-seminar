package de.nordakademie.business.product.impl;

import java.util.List;

import de.nordakademie.business.product.Product;
import de.nordakademie.business.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.nordakademie.business.product.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAll(final String color, final String ps) {
        return productDAO.findAll(color, ps);
    }
}

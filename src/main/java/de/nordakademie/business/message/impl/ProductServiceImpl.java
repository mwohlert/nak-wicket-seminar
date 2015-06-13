package de.nordakademie.business.message.impl;

import java.util.List;

import de.nordakademie.business.message.Product;
import de.nordakademie.business.message.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.nordakademie.business.message.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAll(final String color, final String ps) {
        return productDAO.findAll(color, ps);
    }
}

package de.nordakademie.business.product.impl;

import de.nordakademie.business.product.Product;
import de.nordakademie.business.product.SearchDAO;
import de.nordakademie.business.product.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDAO searchDAO;

    @Override
    public List<Product> findWord(String input,final String color, final String ps){return searchDAO.findWord(input,color,ps) ;}
}


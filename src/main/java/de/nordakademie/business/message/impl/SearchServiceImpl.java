package de.nordakademie.business.message.impl;

import de.nordakademie.business.message.Product;
import de.nordakademie.business.message.SearchDAO;
import de.nordakademie.business.message.SearchService;
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


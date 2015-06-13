package de.nordakademie.business.product;

import java.util.List;

/**
 * Created by xilent on 31.05.15.
 */
public interface SearchService {

    List<Product> findWord(String input,final String color, final String ps);
}

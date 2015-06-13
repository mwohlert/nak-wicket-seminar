package de.nordakademie.business.message;

import java.util.List;

/**
 * Created by xilent on 31.05.15.
 */
public interface SearchDAO  {

    List<Product> findWord(String input,final String color, final String ps);
}

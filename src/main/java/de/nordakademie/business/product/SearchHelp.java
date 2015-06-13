package de.nordakademie.business.product;

/**
 * Created by xilent on 31.05.15.
 */
public class SearchHelp {

    public static boolean isNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}

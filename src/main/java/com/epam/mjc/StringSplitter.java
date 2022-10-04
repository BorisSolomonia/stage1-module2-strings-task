package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        //throw new UnsupportedOperationException("You should implement this method.");
        String parent = "[";

        for (String j : delimiters) {
            parent += j;
        }
        parent += "]";
        String[] firstSt = source.split(parent);
        List<String> listSt = Arrays.asList(firstSt);
        return listSt;
    }
}

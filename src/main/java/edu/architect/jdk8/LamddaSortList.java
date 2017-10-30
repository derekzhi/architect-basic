package edu.architect.jdk8;

import java.util.Arrays;
import java.util.List;

public class LamddaSortList {

    public static void main(String[] args) {
        String[] strs = {"a","ab","bf","ac","bd"};
        List<String> list = Arrays.asList(strs);
        list.sort((e1, e2) -> e1.compareTo(e2));
        System.out.println(list);
    }
}

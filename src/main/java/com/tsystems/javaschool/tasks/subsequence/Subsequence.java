package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {


    public boolean find(List x, List y) {
        if ((x == null) || (y == null)) {
            throw new IllegalArgumentException();
        }
        int border = 0, count = 0;
        boolean f = true;
        for (int i = 0; i < x.size(); i++) {
            if (y.contains(x.get(i))) {
                count++;
            }
        }
        if (count == x.size()) {
            for (int i = 0; i < x.size(); i++) {
                for (int j = border; j < y.size(); j++) {
                    if (y.indexOf(x.get(i)) >= border) {
                        border = y.indexOf(x.get(i));

                    } else {
                        f = false;
                    }
                }
            }
        } else {
            f = false;
        }
        return f;
    }
}
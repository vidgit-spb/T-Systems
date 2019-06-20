package com.tsystems.javaschool.tasks.pyramid;

import java.util.List;
import java.util.Collections;

public class PyramidBuilder {

    public int[][] buildPyramid(List<Integer> inputNumbers) {
        if (inputNumbers.size() > 10000 || inputNumbers.contains(null)) {
            throw new CannotBuildPyramidException();
        }
        int count = 0, r = 0;
        Collections.sort(inputNumbers);
        boolean canBuildPyramid = false;
        for (int i = 0; i < inputNumbers.size(); i++) {
            count += i;
            if (count == inputNumbers.size()) {
                canBuildPyramid = true;
                break;
            }
            r += 1;
        }
        if (!canBuildPyramid) {
            throw new CannotBuildPyramidException();
        }
        int[][] arr = new int[r][2 * r - 1];
        int s = (r - 1) % 2;
        int now = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < 2 * r; j++) {
                if ((j >= r - i - 1) && (j <= r + i - 1) && ((i + j) % 2 == s)) {
                    arr[i][j] = inputNumbers.get(now);
                    now += 1;
                }
            }
        }
        return arr;
    }
}
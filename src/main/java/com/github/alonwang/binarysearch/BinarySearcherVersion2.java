package com.github.alonwang.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author alonwang
 * @date 2020/4/15 18:53
 * @description 查找最后一个等于给定值的元素
 * @detail 与BinarySearcherVersion1类似
 */
public class BinarySearcherVersion2 extends AbstractBinarySearcher {
    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            int len = ThreadLocalRandom.current().nextInt(2000);
            Integer[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt(2000);
            }
            Arrays.sort(arr);
            int randomVal = ThreadLocalRandom.current().nextInt(1500);
            int index = -1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == randomVal) {
                    index = j;
                }
            }
            int searchIndex = new BinarySearcherVersion2().search(arr, randomVal);
            assert searchIndex == index;
        }
    }

    public int search(Comparable[] arr, Comparable target) {
        if (arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmpVal = target.compareTo(arr[mid]);
            if (cmpVal < 0) {
                high = mid - 1;
            } else if (cmpVal == 0) {
                if (mid == arr.length - 1 || target.compareTo(arr[mid + 1]) < 0) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    @Override
    protected void doValidate(List<Integer[]> arrs) {
        arrs.forEach(arr -> {
            int randomVal = ThreadLocalRandom.current().nextInt(1500);
            int index = -1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == randomVal) {
                    index = j;
                }
            }
            int searchIndex = new BinarySearcherVersion2().search(arr, randomVal);
            assert searchIndex == index;
        });

    }
}

package com.github.alonwang.search;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author alonwang
 * @date 2020/4/13 11:48 下午
 * @description 二分查找的最简单形式
 * @detail 几个注意点
 * * low<=high  low==high时,mid==low==high,需要判定mid是否符合要求
 * * mid计算使用low+(high-low)/2而不是(low+high)/2避免溢出
 * * 是low=mid+1 和high=mid-1 ,经过判定之后mid位置是确定不需要的
 * * high是包含的
 */
public class BinarySearcher extends AbstractBinarySearcher {

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
                return mid;
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
            int index = Arrays.stream(arr).filter(v -> v == randomVal).findAny().orElse(-1);
            int searchIndex = search(arr, randomVal);
            assert searchIndex == index;
        });
    }
}

package com.github.alonwang.sort;

public class QuickSorter implements Sorter {
    @Override
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(Comparable[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = partition(arr, low, high);
        quickSort(arr, low, mid);
        quickSort(arr, mid + 1, high);
    }

    private int partition(Comparable[] arr, int low, int high) {
        Comparable cmpValue = arr[high - 1];
        int i = low;
        for (int j = low; j < high - 1; j++) {
            if (arr[j].compareTo(cmpValue) <= 0) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, high - 1);
        return i;
    }

    @Override
    public String name() {
        return "quick";
    }

    public static void main(String[] args) {
        new QuickSorter().performanceTest(new Integer[]{1, 2, 3, 4, 0}, new Integer[]{1, 0}, new Integer[]{0, 1}, new Integer[]{1, 1, 2}, new Integer[]{2, 2, 1});
    }
}
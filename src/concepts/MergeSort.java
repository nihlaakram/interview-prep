/*
 * Copyright (c) 2019, Nihla Akram. All Rights Reserved.
 */

package concepts;

public class MergeSort {

    private int [] arr = {7, 3, 2, 1, 8, 6, 4, 5};
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(0, mergeSort.arr.length-1);
        for (int i : mergeSort.arr) {
            System.out.println(i);
        }

    }

    /*
        Recursive solution - Divide and conquer
        Exit condition - List having one element only
        L - Length of list
        Time Complexity = Time taken to divide + Time taken to merge
                        = O (L * Log L)
        Space Complexity = O(L)
    */
    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    /*
        Combines two sorted lists in to a single sorted list
        Time Complexity = O(Length of Arr1 + Length of Arr2)
        Space Complexity = O(Length of Arr1 + Length of Arr2)
     */
    public void merge(int low, int mid, int high) {
        int a = low, l = 0, r = 0;
        int n1 = mid - low + 1;
        int n2 =  high - mid;

        int[]  left = new int[n1], right = new  int [n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        while ( l < n1 && r < n2 ) {
                if (left[l] < right[r]) {
                    arr[a] = left[l];
                    l++;
                } else {
                    arr[a] = right[r];
                    r++;
                }
                a++;
        }

        while (l < n1) {
            arr[a] = left[l];
            l++;
            a++;
        }

        while (r < n2) {
            arr[a] = right[r];
            r++;
            a++;
        }
    }

}

/**
 * // leetcode: https://leetcode-cn.com/problems/find-in-mountain-array/
 * // by Joyce 参考 https://leetcode-cn.com/problems/find-in-mountain-array/solution/shi-yong-chao-hao-yong-de-er-fen-fa-mo-ban-python-/
 * //step1：找到峰值；
 * //step2：在[0，峰值]找target；
 * //step3：在[峰值，len-1]找target
 *
 */


package com.nice;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 */

interface MountainArray {
    public int get(int index);

    public int length();
}


class MountainArrayImpl implements MountainArray {
    private int[] arr;
    private int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = this.arr.length;
    }

    @Override
    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.size;
    }

}


class Solution1095{
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        int mountainTop = findMountainTop(mountainArr, 0, size - 1);
        int res = findSortedArray(mountainArr, 0, mountainTop, target);
        if (res != -1){
            return res;
        }
        return findFromInversedArray(mountainArr, mountainTop + 1, size - 1, target);

    }


    private int findMountainTop(MountainArray mountainArr, int l, int r) {
        while ( l < r ){
            int mid = l + ( r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        return l;

    }

    private int findSortedArray(MountainArray mountainArr,  int l, int r, int target) {
        while (l < r){
            int mid = l + (r - l) /2;
            if (mountainArr.get(mid) < target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (mountainArr.get(l) == target){
            return l;
        }
        return  -1;
    }

    private int findFromInversedArray(MountainArray mountainArr, int l, int r, int target) {
        while (l < r){
            int mid = l + (r - l) /2;
            if (mountainArr.get(mid) > target){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        if (mountainArr.get(l) == target){
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        MountainArray mountainArray = new MountainArrayImpl(arr);
        Solution1095 solution1095 = new Solution1095();
        solution1095.findInMountainArray(target, mountainArray);
        int res = solution1095.findInMountainArray(target, mountainArray);
        System.out.println(res);


    }

}

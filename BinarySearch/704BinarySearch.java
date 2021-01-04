/*
leetcode: https://leetcode-cn.com/problems/binary-search/
by Joyce
*/
class Solution1 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return -1;
        }
        int left = 0;
        int right = len -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid -1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {1, 2, 3, 5, 9, 10, 12};
        int target = 10;
        int x = solution.search(nums, target);
        System.out.println(x);

    }
}

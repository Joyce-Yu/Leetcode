package 剑指offer;

import java.util.HashMap;

/**
 * @author: Chenbing
 * @date: 2021.01.15 14:10
 * @description:https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 说明：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 */


class Solution50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] arrs = s.toCharArray();
        for (char arr: arrs){
            map.put(arr, !map.containsKey(arr));
        }
        for (char arr: arrs){
            if (map.get(arr)){
                return arr;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

    }
}

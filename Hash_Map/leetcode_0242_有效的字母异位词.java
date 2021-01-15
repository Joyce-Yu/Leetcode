package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.15 17:09
 * @description:
 */
public class leetcode_0242_valid_anagram {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        char[] sArrs = s.toCharArray();
        char[] tArrs = t.toCharArray();

        for (char arr: sArrs){
            record[arr-'a'] += 1;
        }
        for (char arr: tArrs){
            record[arr - 'a'] -= 1;
        }
        for (int num: record){
            if (num != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode_0242_valid_anagram leetcode_0242_valid_anagram = new leetcode_0242_valid_anagram();
        System.out.println(leetcode_0242_valid_anagram.isAnagram("teaa","aet"));
    }
}

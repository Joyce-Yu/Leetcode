package com.nice;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author: Chenbing
 * @date: 2021.01.15 20:34
 * @description:
 */
public class leetcode_0387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        if (s.length() == 0){
            return -1;
        }
        char[] arrs = s.toCharArray();
        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char arr: arrs){
            int count = map.getOrDefault(arr, 0) + 1;
            map.put(arr, count);
        }

        for (int i = 0; i < arrs.length; i++){
            if (map.get(arrs[i])==1){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        leetcode_0387_First_Unique_Character_in_a_String leetcode_0387_first_unique_character_in_a_string = new leetcode_0387_First_Unique_Character_in_a_String();
        System.out.println(leetcode_0387_first_unique_character_in_a_string.firstUniqChar("ninic"));
    }

}

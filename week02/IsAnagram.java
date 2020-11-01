package org.leetcode.question.week02;

import java.util.Arrays;

//[242]给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//异位词
public class IsAnagram {

    /**
     * 排序法
     * 时间复杂度 O(n log n)
     * 空间复杂度 O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t){
        if((s == null || t ==null) || s.length() != t.length()) {
            return false;
        }
        //s.toCharArray 花费了O(n) 额外空间，但通常忽略这个细节
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

    /**
     * 哈希表
     * 1.为了检查t是否是s的重新排列，计算两个字符串中每个字母出现的次数。
     * 2.因为包含A-Z所以一个简单的26位的计数器就可以
     * @param s
     * @param t
     * @return
     */
    public boolean isAnaagram2(String s,String t){
        if((s == null || t ==null) || s.length() != t.length()) {
            return false;
        }
        int[] cArray = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            cArray[s.charAt(i) - 'a']++;
            cArray[t.charAt(i) - 'a']--;
        }
        for (int i : cArray){
            if(i != 0){
                return  false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new IsAnagram().isAnagram(s,t));
        System.out.println(new IsAnagram().isAnagram(s,"magna"));
    }
}

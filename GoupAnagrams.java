package org.leetcode.question.week02;

import java.util.*;

/**
 * 49. 字母异位词分组
 * *给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GoupAnagrams {

    /**
     * 和IsAnagram类似，使用暴力排序法
     * 时间复杂度：O(NK)O(NK)，其中 NN 是 strs 的长度，而 KK 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());

    }

    /**
     * 按计数器方式
     * 在 Java 中，我们的字符数 count 的散列化表示将是一个用 **＃** 字符分隔的字符串。 例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，其中总共有26个条目
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String,List> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs){
            Arrays.fill(count,0);
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0 ; i < 26 ; i++){
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }
            String key = stringBuilder.toString();
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());



    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        GoupAnagrams goupAnagrams = new GoupAnagrams();
        List<List<String>> returnList = goupAnagrams.groupAnagrams2(strs);

        for (List<String> items : returnList){
            System.out.println(items);
            System.out.println("-----------------");
        }

    }
}

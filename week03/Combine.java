package org.leetcode.question.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//77. 组合
//简单思路，问题变成从n-1里选k个 的组合，加上从n-1里选k-1的组合
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> temp = new LinkedList<>();
        combine(n,k, temp);
        return listOfList;
    }

    List<List<Integer>> listOfList = new ArrayList<>();

    public void combine(int n, int k, LinkedList<Integer> res) {
        if (k == 0) {
            listOfList.add(new ArrayList<>(res));
            return;
        }

        if (n > k) {  // 允许从n-1里选k个
            combine(n - 1, k, res);
        }
        res.addFirst(n);
        combine(n - 1, k - 1, res);
        res.removeFirst();
    }
}

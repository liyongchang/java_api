package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutationStr {
    public static void main(String[] args) {
        PermutationStr permutationStr = new PermutationStr();
        permutationStr.permutationStr("123");
        System.out.println(permutationStr.res.toString());
    }

    static Set<String> res = new HashSet<>();

    public String[] permutationStr(String s) {
        if (s == null) return new String[]{};
        boolean[] visited = new boolean[s.length()];
        dfs(s, "", visited);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(String s, String ch, boolean[] visited) {
        System.out.println("dfs: " + "ch=" +ch + " visited[]" + Arrays.toString(visited));
        if (s.length() == ch.length()) {
            res.add(ch);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            System.out.println("i=" + i + " temp=" + temp + " char=" + ch);
            if (visited[i]) {
                System.out.println("跳出i=" + i + " visited=" + visited[i]);
                continue;
            }
            visited[i] = true;
            System.out.println("i=" + i + " visited=" + visited[i]);
            dfs(s, ch + String.valueOf(temp), visited);
            visited[i] = false;
            System.out.println("i=" + i + " visited=" + visited[i]);

        }
    }

}

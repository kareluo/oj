package problems.p508;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int maxCount = 0;

    private int countCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> frequents = new HashMap<>();

        frequentTreeSum(root, frequents);

        int index = 0;
        int[] sets = new int[countCount];
        Set<Map.Entry<Integer, Integer>> entries = frequents.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == maxCount) {
                sets[index++] = entry.getKey();
            }
        }
        return sets;
    }

    private int frequentTreeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int sum = root.val;
        sum += frequentTreeSum(root.left, map);
        sum += frequentTreeSum(root.right, map);
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        if (count > maxCount) {
            maxCount = count;
            countCount = 1;
        } else if (count == maxCount) {
            countCount++;
        }
        return sum;
    }
}
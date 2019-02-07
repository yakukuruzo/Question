package com.example;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetcodeQuestions {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            inorderTraversalHelper(root, result);
        }
        return result;
    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
       return  rangeSumBSTHelper(root, L, R);
    }

    private int rangeSumBSTHelper(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        result += rangeSumBSTHelper(root.left, l, r);
        result += rangeSumBSTHelper(root.right, l, r);

        if (root.val >= l && root.val <= r) {
            result += root.val;
        }
        return result;
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }

        Set<Character> stoneTypes = new HashSet<>();
        for (char type : J.toCharArray()) {
            stoneTypes.add(type);
        }
        int result = 0;
        for (char stone : S.toCharArray()) {
            if (stoneTypes.contains(stone)) {
                result++;
            }
        }
        return result;
    }


    class RangeModule {

        private BitSet mBitSet;

        public RangeModule() {
            mBitSet = new BitSet(1_000_000_000);
        }

        public void addRange(int left, int right) {
            mBitSet.set(left, right, true);

        }

        public boolean queryRange(int left, int right) {
            for (int i = left; i < right; i++) {
                if (!mBitSet.get(i)) {
                    return false;
                }
            }
            return true;
        }

        public void removeRange(int left, int right) {
            mBitSet.set(left, right, false);
        }
    }


}

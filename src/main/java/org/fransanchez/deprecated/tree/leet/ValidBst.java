package org.fransanchez.deprecated.tree.leet;

public class ValidBst {

    public static void main(String[] args) {

    }

    public boolean isValidBST(LeetTreeNode root) {
        return isValidBSTRec(root, null, null);
    }

    public boolean isValidBSTRec(LeetTreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        } else if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }

        return isValidBSTRec(root.left, root.val, min) && isValidBSTRec(root.right, max, root.val);
    }
}

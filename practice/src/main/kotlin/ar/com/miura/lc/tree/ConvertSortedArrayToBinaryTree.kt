package ar.com.miura.lc.tree

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/631/
 */
class ConvertSortedArrayToBinaryTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return getTree(nums, 0, nums.size-1);
    }

    private fun getTree(nums:IntArray, start:Int, end:Int): TreeNode? {

        if (start>end) {
            return null;
        }

        var middlePoint = (end-start)/2 + start;
        var tree = TreeNode(nums[middlePoint]);
        tree.left = getTree(nums, start, middlePoint-1);
        tree.right = getTree(nums, middlePoint+1, end);
        return tree;

    }
}
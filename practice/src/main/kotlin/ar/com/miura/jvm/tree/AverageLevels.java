package ar.com.miura.jvm.tree;

public class AverageLevels {
    public java.util.List<Double> averageOfLevels(TreeNode root) {

        java.util.List<Double> averages = new java.util.ArrayList<Double>();

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            double acum = 0;
            for(int i=0;i<size;i++) {
                acum += queue.peek().val;
                TreeNode node = queue.poll();
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            double average = acum/size*1.0;
            averages.add(average);

        }

        return averages;
    }
}

package ar.com.miura.jvm.tree;

public class ConstructPreorderTestCase {

    @org.junit.jupiter.api.Test
    public void shouldBuildTree() {
        TreeNode treeNode = new ConstructPreorder().bstFromPreorder(new int[]{8,5,1,7,10,12});
        org.junit.jupiter.api.Assertions.assertNotNull(treeNode);
    }

}

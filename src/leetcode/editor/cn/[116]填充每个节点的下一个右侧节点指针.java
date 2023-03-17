package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution116 {
    public Node connect(Node root) {
//       这是第一层
        if (root == null) return root;
        root.next = null;
        Node left = root;

//        这个是因为这个是完美二叉树，所有一定会有左右子节点，可以只看左节点即可
        while (left.left != null){
            Node leftParent = left;
//            下一层进行层序遍历
            while (leftParent != null){
//                同一个节点的左右子树链接
                leftParent.left.next = leftParent.right;
//                父亲兄弟节点的子节点最左链接最右
                if (leftParent.next != null){
                    leftParent.right.next = leftParent.next.left;
                }

                leftParent = leftParent.next;
            }

            left = left.left;
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

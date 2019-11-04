package datastruct.basic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.NoSuchElementException;

/**
 * 该数据结构存储内容必须具备可比性，因此使用<E extends Comparable<E>>
 * 这个实现不能存放重复元素
 */
public class BST<E extends Comparable<E>> {
    /**
     * 存储节点
     */
    private class Node {
        public E e;
        public Node leftChild, rightChild;

        public Node(E e) {
            this.e = e;
            leftChild = null;
            rightChild = null;
        }

        @Override
        public String toString() {
            return e.toString() + " " + leftChild.toString() + " " + rightChild.toString();
        }
    }

    //树根
    private Node root;
    //大小
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            root = add(root, e);
        }
    }

    //以root为根的二分搜索树中插入元素E，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        /*if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.leftChild == null) {
            node.leftChild = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.rightChild == null) {
            node.rightChild = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.leftChild, e);
        }else{
            add(node.rightChild, e);
        }*/
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.leftChild = add(node.leftChild, e);
        } else if (e.compareTo(node.e) > 0) {
            node.rightChild = add(node.rightChild, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) > 0) {
            return contains(root.rightChild, e);
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.leftChild, e);
        } else {
            return true;
        }
    }

    /**
     * 二叉树的前序遍历
     * Pre-Order Traversal
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.e + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    /**
     * 前序遍历  非递归实现
     */
    public void preOrderNonRecursion() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.e + " ");

            if (curr.rightChild != null) {
                stack.push(curr.rightChild);
            }
            if (curr.leftChild != null) {
                stack.push(curr.leftChild);
            }
        }
    }

    /**
     * 中序遍历
     * 根据二叉树性质中序遍历结果为排序好的顺序
     * In-Order Traversal
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftChild);
        System.out.print(node.e + " ");
        inOrder(node.rightChild);
    }

    public void inOrderNotRecursion() {
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.leftChild;
            } else {
                curr = stack.pop();
                System.out.print(curr.e + " ");
                curr = curr.rightChild;
            }
        }
    }

    /**
     * 后续遍历
     * Post-Order Traversal
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.e + " ");
    }

    /**
     * 后序遍历 非递归
     */
    public void postOrderNotRecursion() {
        Stack<Node> stack = new Stack<>();
        Stack<Node> out = new Stack<>();
        Node curr = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.pop();
//            System.out.print(curr.e + ",");
            out.push(curr);
            if (curr.leftChild != null) {
                stack.push(curr.leftChild);
            }
            if (curr.rightChild != null) {
                stack.push(curr.rightChild);
            }
        }
        while (!out.isEmpty()) {
            System.out.print(out.pop().e + " ");
        }
    }

    /**
     * 层序遍历
     */
    public void layerTraverse() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.print(curr.e + " ");
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
        }
    }

    /**
     * 查找最小值
     */
    public E miniElement() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty.");
        }
        return mini(root).e;
    }

    private Node mini(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return mini(node.leftChild);
    }

    /**
     * 查找最大值
     */
    public E maxElement() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty.");
        }
        return max(root).e;
    }

    private Node max(Node node) {
        if (node.rightChild == null) {
            return node;
        }
        return max(node.rightChild);
    }

    /**
     * 删除最小值
     */
    public E removeMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        E e = miniElement();
        root = removeMin(root);
        return e;
    }

    /**
     * 删除最小值
     *
     * @param root 需要删除的树根
     * @return 被删除树树根
     */
    private Node removeMin(Node root) {
        if (root.leftChild == null) {
            size--;
            return root.rightChild;
        }
        root.leftChild = removeMin(root.leftChild);
        return root;
    }

    public E removeMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        E e = maxElement();
        root = removeMax(root);
        return e;
    }

    //删除以root为根节点的树种最小的元素，返回新的树根
    private Node removeMax(Node root) {
        if (root.rightChild == null) {
            size--;
            return root.leftChild;
        }
        root.rightChild = removeMax(root.rightChild);

        return root;
    }

    /**
     * 删除任意一个节点
     */
    public void remove(E e) {

        root = remove(root, e);

    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }
        int cmp = e.compareTo(node.e);
        if (cmp > 0) {
            node.rightChild = remove(node.rightChild, e);
        } else if (cmp < 0) {
            node.leftChild = remove(node.leftChild, e);
        } else {
            if (node.rightChild == null) {
                return node.leftChild;
            }
            if (node.leftChild == null) {
                return node.rightChild;
            }
            Node tmp = node;
            node = mini(tmp.rightChild);
            node.rightChild = removeMin(tmp.rightChild);
            node.leftChild = tmp.leftChild;

        }

        return node;
    }

    @Override
    public String toString() {
        return "s";
    }


}

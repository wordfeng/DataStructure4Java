package datastruct.basic.tree;

import org.junit.Test;

import java.util.Random;

public class BSTTest {
    @Test
    public void traverseTest() {
        BST<Integer> tree = new BST<>();
        Integer[] u = {7, 5, 1, 3, 9, 10, 2, 4};//5,3,6,8,4,2
        for (Integer integer : u) {
            tree.add(integer);
        }
        System.out.print("前序遍历: ");
        tree.preOrder();
        System.out.print("\n非递归前序遍历: ");
        tree.preOrderNonRecursion();
        System.out.print("\n中序遍历: ");
        tree.inOrder();
        System.out.print("\n非递归中序遍历: ");
        tree.inOrderNotRecursion();
        System.out.print("\n后续遍历: ");
        tree.postOrder();
        System.out.print("\n非递归后续遍历: ");
        tree.postOrderNotRecursion();
        System.out.print("\n层序遍历: ");
        tree.layerTraverse();
    }

    @Test
    public void deleteTest() {
        BST<Integer> b = new BST<>();
        Random random = new Random();
        Integer[] u = {7, 5, 1, 3, 9, 10, 2, 4};//5,3,6,8,4,2
        for (Integer integer : u) {
            b.add(integer);
        }
     /*   for (int i = 0; i < 10000; i++) {
            b.add(random.nextInt(10000));
        }*/
        while (!b.isEmpty()) {
            System.out.println("size"+b.size());
            System.out.println(b.removeMax());
        }System.out.println("size"+b.size());
    }

    @Test
    public void removeEve(){
        BST<Integer> b = new BST<>();
        Integer[] u = {7, 5, 1, 3, 9, 10, 2, 4,0,1,2,7};//5,3,6,8,4,2
        for (Integer integer : u) {
            b.add(integer);
        }
        b.inOrder();
        System.out.println("-----"+b.size());
        b.remove(7);
        System.out.println("====="+b.size());
        b.inOrder();
    }

    @Test
    public void removeMinMax(){
        BST<Integer> b = new BST<>();
        Integer[] u = {7, 5, 1, 3, 9, 10, 2, 4,0};//5,3,6,8,4,2
        for (Integer integer : u) {
            b.add(integer);
        }
        System.out.println(b.removeMin());
        b.inOrder();
        System.out.println();
        System.out.println(b.removeMin());
        b.inOrder();

    }
}

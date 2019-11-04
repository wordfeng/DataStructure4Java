package datastruct.basic.linkedlist;

import org.junit.Test;

public class LinkedListTest {
    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }
            System.out.println(list);
        list.addLast(0);
        System.out.println(list);
        list.add(3, 99);
        System.out.println(list);
        //LinkedList size: 4,
        //	[4-->3-->2-->1-->null]
        //LinkedList size: 5,
        //	[4-->3-->2-->1-->0-->null]
        //LinkedList size: 6,
        //	[4-->3-->2-->99-->1-->0-->null]
        list.deleteElement(99);
        System.out.println(list);
        list.deleteElement(9);
        list.deleteElement(0);
        System.out.println(list);
    }
}

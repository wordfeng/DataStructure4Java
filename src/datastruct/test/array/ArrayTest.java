package datastruct.test.array;

import datastruct.basic.array.Array;
import org.junit.Test;

public class ArrayTest {
    Array<Integer> a = new Array<>();

    @Test
    public void testAdd() {

        for (int i = 0; i < 50; i++) {
            a.add(i);
//            System.out.println("size: "+a.getSize()+" capacity: "+a.getCapacity());
        }
//        a.addFirst(111);
//        System.out.println(a.toString());
//        a.add(1,5);
//        a.add(a.getSize(),99);
//        System.out.println(a.toString());

        testRemove();

    }
    @Test
    public void testRemove(){
        System.out.println();
        for (int i = 0; i < 50; i++) {
            System.out.println("size: "+a.getSize()+" capacity: "+a.getCapacity());
            a.removeFirst();
        }
//        a.removeFirst();
    }
}
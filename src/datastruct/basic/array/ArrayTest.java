package datastruct.basic.array;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void test() {
        Array<Integer> a = new Array<>(5);
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(5);
        a.add(6);
        System.out.println(a);
        a.add(7);
        a.remove(3);
        System.out.println(a);
        a.add(3, 99);
//        a.add(7);
//        a.addFirst(0);
//        a.add(3,3);
//        a.remove(5);
//        a.removeFirst();
//        a.removeLast();
//        a.set(4,5);
       /* System.out.println(a);
        Array<Student> studentArray = new Array<>();
        Student s = new Student();
        s.setAge(20);
        s.setName("张三");
        studentArray.add(s);o
        System.out.println(studentArray);*/
        System.out.println("-----------");
/*        for (Integer integer : a) {
            System.out.println(integer);
        }*/
//        Iterator iterator = a.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        for (Integer integer : a) {
//            System.out.println(integer);
//        }

    }
}
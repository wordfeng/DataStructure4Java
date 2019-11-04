package datastruct.basic.queue;

import org.junit.Test;

import java.util.Random;

public class LoopQueueTest {
    @Test
    public void testLoopQueueResizeFirstSysCopy() {
        int[] i = new int[]{1, 2, 3, 4, 5, 6};
        int[] a = new int[]{0, 0, 0, 0, 0, 0, 0,};
        System.arraycopy(i, 0, a, 0, 2);
        for (int i1 : a) {
            System.out.println(i1);
        }
    }

    @Test
    public void testLoopQueueResizeSecondSysCopy() {
        int[] i = new int[]{1, 2, 3, 4, 5};
        int[] a = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(i, 3, a, 8 - (5 - 3), 5 - 3);
        for (int i1 : a) {
            System.out.print(i1 + ",");
        }
    }

    /**
     * 该测试结果与预期不同
     */
    @Test
    public void testLoopQueue() {
        LoopQueue<Integer> l = new LoopQueue<>(5);
        for (int i = 1; i < 6; i++) {
            l.enqueue(i);
            System.out.println(l);
        }
    }

    @Test
    public void testLoopQueue2() {
        LoopQueue<Integer> l = new LoopQueue<>(5);
        for (int i = 1; i < 6; i++) {
            l.enqueue(i);
            System.out.println(l);
        }
        System.out.println("--------------");
        l.dequeue();
        System.out.println(l);
        for (int i = 6; i < 9; i++) {
            l.enqueue(i);
            System.out.println(l);
        }
    }

    public double timeTestQueueStub(Queue<Integer> queue, int times) {

        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < times; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void timeTestQueue() {
        int count = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("ArrayQueue: " + timeTestQueueStub(arrayQueue, count));
        System.out.println("LoopQueue: " + timeTestQueueStub(loopQueue, count));
        //ArrayQueue: 0.013026661
        //LoopQueue: 0.01135644
    }
}

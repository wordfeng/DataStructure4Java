package datastruct.basic.queue;

public interface Queue<E> {

    /**
     * 入队
     * @param element
     */
    void enqueue(E element);

    /**
     * 从队头出队
     * @return
     */
    E dequeue();

    /**
     * 查看队头元素
     * @return 队头
     */
    E getFront();

    int getSize();

    boolean isEmpty();

}

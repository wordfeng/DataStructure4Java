package datastruct.basic.queue;

/**
 * 普通队列没有意义
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        this.capacity = capacity;
        head = 0;
        tail = 0;

    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public void enqueue(E element) {
        if (getSize() == capacity) {
            resize(2 * capacity);
        }
        data[tail] = element;
        tail++;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, head, newData, 0, size);
        data = newData;
        head = 0;
        tail = size;
        this.capacity = newCapacity;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }
        E e = data[head];
        head++;
        size--;
        return e;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}

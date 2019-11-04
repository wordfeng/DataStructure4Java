package datastruct.basic.queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int tail, head;
    private int size;
    private int capacity;

    /**
     * 判断空满的时候会浪费一个元素空间 所以capacity+1
     *
     * @param capacity
     */
    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.capacity = capacity + 1;
        this.tail = 0;
        this.head = 0;
        this.size = 0;

    }

    public LoopQueue() {
        this(10);
    }


    @Override
    public void enqueue(E element) {
        if (isFull()) {
            resize(2 * (capacity - 1));
        }
        data[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty");
        }
        if (size <= capacity / 4) {
            resize((capacity-1) / 2);
        }
        E e = data[head];
        data[head] = null;
        head = (head + 1) % capacity;
        size--;
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty");
        }
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

    public int getCapacity() {
        return capacity - 1;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        if (head < tail) {
            System.arraycopy(data, head, newData, 0, size);
        } else {
            //head 到 末尾那一段
            System.arraycopy(data, head, newData, 0, capacity - head);
            //0 到 tail那一段 放在head那一段后面
            System.arraycopy(data, 0, newData, capacity - head, tail);
        }
       /* if (head != 0) {
            System.arraycopy(data, head, newData, newCapacity - (capacity - head), capacity - head);
        }*/
        tail = size;
        head = 0;
        capacity = newCapacity+1;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("LoopQueue: size = %d, capacity =%d\n\tQueue:[", size, getCapacity()));
        //打印整个队列
        for (int i = 0; i < data.length; i++) {
            E e = data[i];
            sb.append(e);
            if (i != capacity) {
                sb.append(",");
            }
        }
        sb.append("]\n\tElements:[");
        //只打印队列中元素
        for (int i = head; i != tail; i = (i + 1) % capacity) {
            sb.append(data[i]);
            if (i != tail - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

}

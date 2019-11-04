package datastruct.basic.stack;

/**
 * @author 肖宇峰
 * @date 2019.7.14
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>{
    private E data[];
    private int size;
    private int capacity;

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    public ArrayStack() {
        //默认值
        this(5);
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    @Override
    public E pop() {
        E e;
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is Empty.");
        }
        e = data[size - 1];
        size--;
        return e;
    }

    @Override
    public void push(E element) {
        if (isFull()) {
            throw new IllegalArgumentException("Stack is full.");
        }
        data[size] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Stack size = %d,%d\n[", size, capacity));
        for (int i = 0; i < size; i++) {
           sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}


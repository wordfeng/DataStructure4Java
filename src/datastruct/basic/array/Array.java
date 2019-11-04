package datastruct.basic.array;

/**
 * Class Array
 *
 * @param <T>
 * @author 肖宇峰
 * @date 2019/7/8
 */
public class Array<T> /*implements Iterable<T>*/ {
    private int capacity;
    private T[] data;
    //大小
    private int size;
    private boolean reduceCapacity = true;

    //容量
    //private int capacity;

    public Array(int initCapacity) {
        //data = new T[capacity];
        this.data = (T[]) new Object[initCapacity];
        //this.capacity = capacity;
        this.size = 0;
    }

    /**
     * @param initCapacity   初始容量
     * @param reduceCapacity 是否开启容量减少策略，默认true开启
     */
    public Array(int initCapacity, boolean reduceCapacity) {
        //data = new T[capacity];
        this.data = (T[]) new Object[initCapacity];
        this.reduceCapacity = reduceCapacity;
        this.capacity = capacity;
        this.size = 0;
    }

    public Array(Class<?> type, int initCapacity) {
        this.data = (T[]) java.lang.reflect.Array.newInstance(type, initCapacity);
        this.capacity = capacity;
        this.size = 0;
    }


    /**
     * 默认容量16
     */
    public Array() {
        this(16);
    }

    /**
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 插入新元素到index位置
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引错误");
        }
        //容量判断  扩容暂未实现
        if (size == getCapacity()) {
            //throw new IllegalArgumentException("容量不足");
            //2 * data.length
            resize(data.length << 1);
        }
       /* for (int i = size - 1; i >= index; i--) {
            this.data[i + 1] = data[i];
        }*/
        System.arraycopy(data, index, data, index + 1, data.length - 1 - index);
        data[index] = element;
        size++;

    }

    private void resize(int newCapacity) {
//        if (newCapacity > minCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        capacity = newCapacity;
        data = newData;
//        }
    }

    /**
     * 添加到最前面
     */
    public void addFirst(T element) {
        add(0, element);
    }

    /**
     * 在末尾添加
     */
    public void add(T element) {
        /*data[size] = element;
        size++;*/
        add(size, element);
    }

    /**
     * 获取index位置的元素
     */
    public T get(int index) {
        outOfIndexCheck(index, "Out of index.");
        return data[index];
    }

    /**
     * 更新index位置的元素
     */
    public void set(int index, T element) {
        outOfIndexCheck(index, "Out of index.");
        data[index] = element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含元素
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            //if (data[i] == element) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取元素的索引
     *
     * @param element
     * @return
     */
    public int getIndex(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index
     * @return 删除的元素
     */
    public T remove(int index) {
        outOfIndexCheck(index, "Remove failed. Out of index.");
        T e = data[index];
        System.arraycopy(data, index + 1, data, index, data.length - 1 - index);
        size--;
        data[size] = null;
        if (reduceCapacity && (size == data.length >> 1 >> 1) && (data.length >> 1 != 0)) {
            // data.length/4
            resize(data.length >> 1);
        }

        return e;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    private void outOfIndexCheck(int index, String exceptionWords) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(exceptionWords);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: size = ").append(size).append(", capacity = ").append(getCapacity()).append(" \n[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

/*    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        int cursor = 0;
        T next ;
        @Override
        public boolean hasNext() {
            return cursor!=size;
        }

        @Override
        public T next() {
            if(cursor!=capacity){
                next = data[cursor];
                cursor++;
            }
            return next;
        }
    }*/

}
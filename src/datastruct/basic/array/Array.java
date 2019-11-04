package datastruct.basic.array;

/**
 * 一个简单的动态数组
 * @param <T>
 * @author 肖宇峰
 * @date 2019/7/8
 */
public class Array<T>{
    /**
     * 容量
     */
    private int capacity;

    private final int DEFAULT_CAPACITY = 16;
    /**
     * 数据存储类
     */
    private T[] data;
    /**
     * 数组长度
     */
    private int size;

    /**
     * 容量减少策略
     */
    private boolean reduceCapacity = true;

    /**
     * 默认容量16
     */
    public Array() {
        this(16);
    }

    /**
     * 初始化容量
     * @param initCapacity 估计需要的长度
     */
    public Array(int initCapacity) {
        this.data = (T[]) new Object[initCapacity];
        this.size = 0;
    }

    /**
     * @param initCapacity   初始容量
     * @param reduceCapacity 是否开启容量减少策略，默认true开启
     */
    public Array(int initCapacity, boolean reduceCapacity) {
//        (T[]) java.lang.reflect.Array.newInstance(type, initCapacity);
        this.data = (T[]) new Object[initCapacity];
        this.reduceCapacity = reduceCapacity;
        this.capacity = initCapacity;
        this.size = 0;
    }

    /**
     * @return 元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return 容量
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 插入新元素到index位置
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引错误");
        }
        if (size == getCapacity()) {
            //throw new IllegalArgumentException("容量不足");
            //2 * data.length
            resize(this.data.length << 1);
        }
       /* for (int i = size - 1; i >= index; i--) {
            this.data[i + 1] = data[i];
        }*/
        System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
        this.data[index] = element;
        this.size++;

    }

    private void resize(int newCapacity) {
        if(newCapacity<this.DEFAULT_CAPACITY){
            return;
        }
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(this.data, 0, newData, 0, size);
        this.capacity = newCapacity;
        this.data = newData;
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
        add(this.size, element);
    }

    /**
     * 获取index位置的元素
     */
    public T get(int index) {
        outOfIndexCheck(index, "Out of index.");
        return this.data[index];
    }

    /**
     * 更新index位置的元素
     */
    public void set(int index, T element) {
        outOfIndexCheck(index, "Out of index.");
        this.data[index] = element;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 是否包含元素
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.data[i])) {
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
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
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
        outOfIndexCheck(index, "Remove failed. Out of bound.");
        T e = this.data[index];
        System.arraycopy(this.data, index + 1, this.data, index, this.data.length - 1 - index);
        this.size--;
        this.data[size] = null;
        if (this.reduceCapacity && (this.size == this.data.length >> 1 >> 1) && (this.data.length >> 1 != 0)) {
            // data.length/4
            resize(this.data.length >> 1);
        }

        return e;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(this.size - 1);
    }

    private void outOfIndexCheck(int index, String exceptionWords) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException(exceptionWords);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: size = ").append(this.size).append(", capacity = ").append(getCapacity()).append(" \n[").append(this.data[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(", ");
            sb.append(this.data[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
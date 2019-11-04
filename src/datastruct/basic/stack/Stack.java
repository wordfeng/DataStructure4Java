package datastruct.basic.stack;

public interface Stack<E> {

    /**
     *  返回当前栈中的元素个数
     * @return array.length
     */
    public int getSize();

    /**
     * 判断栈是否为空
     * @return size == -1
     */
    public boolean isEmpty();

    /**
     * 返回栈顶的元素
     * @return 栈顶元素
     */
    public E peek();

    /**
     * 元素出栈
     * @return 出栈的元素
     */
    public E pop();

    /**
     * 元素入栈
     */
    public void push(E element);

    /**
     * 判断是否满了
     * @return bool
     */
    public boolean isFull();
}

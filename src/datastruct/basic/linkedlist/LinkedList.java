package datastruct.basic.linkedlist;

public class LinkedList<E> {


    private class Node {
        private E element;
        private Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node head;
    //    private Node tail;
    private int size;

    public LinkedList() {
        head = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E element) {
        /*Node node = new Node(element);
        node.next = head;
        head = node;*/
        //head = new Node(element, head);
        //与上不同 专门使用一个节点来存储head，head不存放任何元素，只存放next(最后一次添加的元素)
        //目的是在添加元素时更方便

        head.setNext(new Node(element, head.getNext()));
//        head.next = new Node(element, head.next);
        size++;
    }


    /**
     * 把最新加入的元素看作是index = 0
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Out of index.");
        }
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.getNext();
        }
        pre.setNext(new Node(element, pre.getNext()));
        size++;
    }

    /**
     * 把最新加入的元素看作是头
     */
    public void addLast(E element) {
        add(size, element);
    }

    public E deleteElement(E element) {
        //Node current = head.getNext();
        //虽然优雅，但如果没有这个元素就GG
       /* while (current.getElement() != element) {
            current = current.getNext();
        }*/
        Node current = head;
        Node prev = head;
        E e;
        while ((current = current.getNext()) != null) {
            if (current.getElement() == element) {
                e = current.getElement();
                prev.setNext(current.getNext());
                current.setNext(null);
                size--;
                return e;
            }
            prev = current;
        }
        return null;
    }

    public boolean contains(E e) {
        Node node = head;
        while ((node = node.next) != null) {
            if (node.element == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("LinkedList size: %d,\n\t[", getSize()));
        Node node = head;
        while ((node = node.getNext()) != null) {
            sb.append(node.getElement()).append("-->");
        }
        sb.append("null]");
        return sb.toString();

    }
}

package personal.practices.job.zaxiang;

import java.util.Objects;

/**
 * Created by Stubborn on 2017/10/24.
 */
public class BasicDataStructure {

    /**
     * 实现一个单链表
     */
    class Node {

        Node next = null;

        Node previous = null;

        Object data;

        public Node(Object data) {
            this.data = data;
        }

    }

    class SingleLinkedList {

        Node lastNode;

        public void appendToTail(Object data) {
            Node endNode = new Node(data);
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode = endNode;

        }

        public void appendToThis(Object data, Node thisNode) {
            Node newNode = new Node(data);
            newNode.next = thisNode.next;
            thisNode.next = newNode;
        }
    }

    class Stack {

        Node top;

        public Object pop() {
            if (top != null) {
                Object data = top.data;
                top = top.next;
                return data;
            }
            return null;
        }

        public void push(Object data) {
            Node node = new Node(data);
            node.next = top;
            top = node;
        }

        public Object peek() {
            return top.data;
        }
    }

    class Queue {

        Node first;

        Node last;

        public void enQueue(Object data) {
            Node newNode = new Node(data);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }

        public Object deQueue() {
            if (first != null) {
                first = first.next;
                return first.data;
            }
            return null;
        }
    }
}

package com.bugjc.java.basics.container.linkedlist;

import java.util.*;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * @author Zheng
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null){
            return;
        }
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    public void deleteByNode(Node p) {
        if (p == null || head == null){
            return;
        }

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null){
            return;
        }

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null){
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
    /*
    if (head != null && head.data == value) {
    	head = head.next;
    }
    Node pNode = head;
    while (pNode != null) {
    	if (pNode.next.data == data) {
    		pNode.next = pNode.next.next;
    		continue;
    	}
    	pNode = pNode.next;
    }
    */
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertAfter(SinglyLinkedList.createNode(1),SinglyLinkedList.createNode(2));

        Map map = new HashMap();

        //创建一个LinkedList并添加3个值,结果{4,3,5}
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.addFirst(4);
        linkedList.addLast(5);
        //删除索引为2的值，结果{4,3}
        linkedList.remove(2);
        //查找首节点,结果：4
        linkedList.getFirst();

        //------------队列相关操作----------
        //返回第一个节点,结果：4
        //若LinkedList的大小为0,则返回null
        Integer node = linkedList.peek();
        if (node == null){
            return;
        }

        // 删除并返回第一个节点,结果：4
        // 若LinkedList的大小为0,则返回null
        linkedList.poll();
        // 删除并返回第一个节点,结果：3
        // 若LinkedList的大小为0,则抛出NoSuchElementException异常
        linkedList.pop();
    }
}

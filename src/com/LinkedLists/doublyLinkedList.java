package com.LinkedLists;

public class doublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int d){
            data = d;
            prev = null;
            next = null;
        }
    }
    Node head;

    public static doublyLinkedList insertFront(doublyLinkedList list,int d) {
        Node new_node = new Node(d);

        if(list.head==null) {
            new_node.prev=null;
            new_node.next=null;
        } else {
            list.head.prev = new_node;
            new_node.next = list.head;
            new_node.prev = null;
        }
        list.head = new_node;

        return list;
    }

    public static doublyLinkedList insertRear(doublyLinkedList list, int d) {
        Node new_node = new Node(d);
        new_node.next = null;

        if(list.head == null) {
            new_node.prev = null;
        } else {
            Node cur = list.head;
            while(cur.next!=null) {
                cur = cur.next;
            }
            cur.next = new_node;
            new_node.prev = cur;
        }

        return list;
    }

    public static doublyLinkedList insertPos(doublyLinkedList list, int data, int pos) {
        Node new_node = new Node(data);

        int count=0;
        if(list.head==null && pos==1){
            new_node.next=null;
            new_node.prev=null;
            list.head=new_node;
        }

        return list;
    }

    public static doublyLinkedList deleteFront(doublyLinkedList list) {
        if(list.head==null) {
            System.out.println("Invalid Operation!! List is empty!!");
            return list;
        }

        if(list.head.next == null) {
            list.head = null;
            return list;
        }

        list.head = list.head.next;
        list.head.prev = null;

        return list;
    }

    public static doublyLinkedList deleteRear(doublyLinkedList list) {
        if(list.head == null) {
            System.out.println("Invalid operation!! List is Empty!!");
            return list;
        }

        if(list.head.next == null) {
            list.head = null;
            return list;
        }

        Node cur = list.head;
        Node prev = null;
        while(cur.next!=null) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;

        return list;
    }

    public static void display(doublyLinkedList list) {
        Node cur = list.head;

        if(list.head == null) {
            System.out.println("List is Empty !!");
            return;
        }

        while(cur!=null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        doublyLinkedList list = new doublyLinkedList();

        System.out.println("Inserting elements at the front :");
        list = insertFront(list, 9);
        list = insertFront(list, 8);
        display(list);

        System.out.println("Inserting elements at the rear :");
        list = insertRear(list, 7);
        list = insertRear(list, 6);
        list = insertRear(list, 5);
        display(list);

        //
        System.out.println("Delete first element from front :");
        list = deleteFront(list);
        display(list);

        System.out.println("Deleting second element from front :");
        list = deleteFront(list);
        list = deleteFront(list);
        display(list);

        System.out.println("Deleting element from rear :");
        list = deleteRear(list);
        display(list);

        System.out.println("Deleting last element from rear :");
        list = deleteRear(list);
        display(list);

        System.out.println("Deleting last element from rear :");
        list = deleteRear(list);
        display(list);
    }
}

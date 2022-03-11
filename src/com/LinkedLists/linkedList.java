package com.LinkedLists;

public class linkedList {

    // Node structure
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }
    }

    // Class variable for `head` node
    Node head;

    public static linkedList insertLast(linkedList list, int data)
    {
        Node new_node = new Node(data);
        new_node.next = null;

        if(list.head == null){
            list.head = new_node;
        }else{
            Node cur = list.head;
            while(cur.next!=null)
            {
                cur = cur.next;
            }
            cur.next = new_node;
        }

        return list;
    }

    public static linkedList insertFront(linkedList list, int data){
        Node new_node = new Node(data);

        if(list.head == null) {
            new_node.next = null;
        }
        else {
            new_node.next = list.head;
        }
        list.head = new_node;

        return list;
    }

    public static linkedList insertPos(linkedList list, int pos, int data) {
        Node new_node = new Node(data);
        if(list.head == null) {
            new_node.next = null;
            list.head = new_node;
        }

        int count = 1;
        Node cur = list.head;
        Node prev = null;
        while(count!=pos && cur!=null) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        if(count == pos)
        {
            prev.next = new_node;
            new_node.next = cur;
        }

        if(cur==null) {
            System.out.println("Invalid Position");
        }

        return list;
    }

    public static linkedList deleteFront(linkedList list)
    {
        if(list.head == null)
        {
            System.out.println("Invalid Operation. List is Empty !!");
            return list;
        }

        Node next_node = list.head;
        list.head = next_node.next;

        return list;
    }

    public static linkedList deleteLast(linkedList list) {
        if(list.head == null)
        {
            System.out.println("Invalid Operation. List is Empty !!");
        }

        Node cur = list.head;
        Node prev = null;
        while(cur.next!=null)
        {
            prev = cur;
            cur=cur.next;
        }
        prev.next = null;
        return list;
    }

    public static linkedList deletePos(linkedList list, int pos)
    {
        if(list.head == null)
        {
            System.out.println("Invalid Operation !! List is Empty!!");
        }

        Node cur = list.head;
        if(pos==1 && cur.next==null)
        {
            list.head=null;
            return list;
        }

        int count=1;
        Node prev = null;
        while(count!=pos && cur!=null)
        {
            prev = cur;
            cur = cur.next;
            count++;
        }

        if(count==pos)
        {
            prev.next = cur.next;
        }

        if(cur==null)
        {
            System.out.println("Invalid position");
        }

        return list;
    }

    public static void display(linkedList list)
    {
        if(list.head == null)
        {
            System.out.println("List is empty");
            System.exit(0);
        }

        Node cur = list.head;
        while(cur!=null)
        {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        linkedList list = new linkedList();

        // insert last
        list = insertLast(list, 1);
        list = insertLast(list, 5);
        list = insertLast(list, 8);
        list = insertLast(list, 7);

        // insert front
        list = insertFront(list, 3);
        list = insertFront(list, 4);

        // inset position
        list  = insertPos(list, 2, 2);
        list = insertPos(list, 6, 6);

        // display list
        display(list);

        System.out.println("\nAfter deleting first element : ");
        list = deleteFront(list);
        display(list);

        System.out.println("\nAfter deleting last element : ");
        list = deleteLast(list);
        display(list);

        System.out.println("\nDelete at Position 3 : ");
        list = deletePos(list, 3);
        display(list);
    }
}

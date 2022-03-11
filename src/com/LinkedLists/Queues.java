package com.LinkedLists;

public class Queues {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    public static Queues insertLast(Queues que, int d)
    {
        Node new_node = new Node(d);

        if(que.head == null) {
            new_node.next = null;
            que.head = new_node;
        } else {
            Node cur = que.head;
            while(cur.next!=null)
            {
                cur = cur.next;
            }
            cur.next = new_node;
            new_node.next = null;
        }

        return que;
    }

    public static Queues deleteFront(Queues que) {
        if(que.head == null) {
            System.out.println("Invalid Operation !!");
        } else {
            que.head = que.head.next;
        }
        return que;
    }

    public static void display(Queues que) {
        if(que.head == null) {
            System.out.println("Queue is Empty !!");
            return;
        }

        Node cur = que.head;
        while(cur!=null)
        {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queues que = new Queues();

        System.out.println("Inserting int Queue (5<--7<--9) :");
        que = insertLast(que, 5); // 1st element
        que = insertLast(que, 7); // 2nd element
        que = insertLast(que, 9); // 3rd element
        display(que);

        System.out.println("Deleting First Element : ");
        que = deleteFront(que);
        display(que);

        System.out.println("Delete remaining elements : ");
        que = deleteFront(que);
        que = deleteFront(que);
        display(que);

        System.out.println("Trying to delete elements from empty queue :");
        que = deleteFront(que);
        display(que);
    }

}

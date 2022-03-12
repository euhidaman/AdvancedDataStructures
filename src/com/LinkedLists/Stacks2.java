// Stacks with Linked Lists with upper limit of 4
package com.LinkedLists;

public class Stacks2 {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data=d;
            next=null;
        }
    }
    Node head;

    static int limit = 4;
    static int count = 0;

    public static Stacks2 insertTop(Stacks2 st, int item) {
        Node new_node = new Node(item);

        if(count == limit) {
            System.out.println("Stack is Full !! Invalid Operation !!");
            return st;
        }

        if(st.head == null) {
            new_node.next = null;
            st.head = new_node;
        } else {
            new_node.next = st.head;
            st.head = new_node;
        }

        count++;
        return st;
    }

    public static Stacks2 deleteTop(Stacks2 st) {

        if(st.head == null) {
            System.out.println("Invalid Operation!! Stack is Empty");
            return st;
        }

        st.head = st.head.next;
        return st;
    }

    public static void display(Stacks2 st) {
        Node cur = st.head;

        if(cur == null) {
            System.out.println("Stack is Empty !!");
            return;
        }

        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Stacks2 st = new Stacks2();

        // filling items in order --> 9,8,7,6
        st = insertTop(st, 9);
        st = insertTop(st, 8);
        st = insertTop(st, 7);
        st = insertTop(st, 6);
        display(st);

        // trying to fill in a full-stack
        st = insertTop(st, 5);
        display(st);

        // deleting elements from the stack
        System.out.println("Deleting top 2 elements : ");
        st = deleteTop(st);
        st = deleteTop(st);
        display(st);

        System.out.println("Making Stack Empty : ");
        st = deleteTop(st);
        st = deleteTop(st);
        display(st);

        System.out.println("Trying to delete from Empty stack : ");
        st = deleteTop(st);
        display(st);
    }
}
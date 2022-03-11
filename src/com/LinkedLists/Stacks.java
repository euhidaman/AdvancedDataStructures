package com.LinkedLists;

public class Stacks {

    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }
    }

    Node head;

    public static Stacks insertTop(int item, Stacks stack)
    {
        Node new_node = new Node(item);
        if(stack.head == null)
        {
            new_node.next=null;
        } else {
            new_node.next = stack.head;
        }
        stack.head = new_node;

        return stack;
    }

    public static Stacks deleteTop(Stacks stack) {
        if(stack.head == null) {
            System.out.println("Invalid Operation !!");
            return stack;
        }

        if(stack.head.next == null)
        {
            stack.head = null;
        } else {
            stack.head = stack.head.next;
        }

        return stack;
    }

    public static void display(Stacks stack)
    {
        if(stack.head==null)
        {
            System.out.println("Stack is Empty !!");
            return;
        }

        Node cur = stack.head;
        while(cur!=null)
        {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Stacks stack = new Stacks();

        //insert top
        System.out.println("After inserting 7 & 5 :");
        stack = insertTop(5, stack);
        stack = insertTop(7, stack);
        display(stack);

        System.out.println("After deleting top element (i.e, 7) :");
        stack = deleteTop(stack);
        display(stack);

        System.out.println("After deleting only element (i.e, 5) :");
        stack = deleteTop(stack);
        display(stack);

        System.out.println("Trying to delete from empty stack :");
        stack = deleteTop(stack);
        display(stack);
    }

}

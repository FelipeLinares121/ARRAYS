/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.stacks;

import edu.upb.models.Excepcion;
import edu.upb.models.Node;
import edu.upb.models.IStack;

/**
 *
 * @author cahuc
 */
public class LinkedStack implements IStack {

    private Node top = null;

    @Override
    public void push(Object item) {
        top = new Node(item, top);
    }

    @Override
    public Object pop() {

        if (top == null) {
            throw new Excepcion("Cannot pop from empty stack");
        }

        Object item = peek();
        top = top.getNext();
        return item;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Object peek() {
        if (top == null) {
            throw new Excepcion("Cannot peek from empty stack");
        }
        return top.getData();
    }

    @Override
    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.getNext()) {
            count++;
        }
        return count;
    }
}

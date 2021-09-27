/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.stacks;

import edu.upb.models.Excepcion;
import edu.upb.models.IStack;

/**
 *
 * @author cahuc
 */
/**
 * An implementation of a stack using a static size array whose
 * capacity is set in its constructor.
 */
public class ArrayStack implements IStack {

    private final Object[] array;
    private int size = 0;

    public ArrayStack(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public void push(Object item) {
        if (size == array.length) {
            throw new Excepcion("Cannot add to full stack");
        }
        array[size++] = item;
    }

    @Override
    public Object pop() throws Excepcion {
        if (size == 0) {
            throw new Excepcion("Cannot pop from empty stack");
        }
        Object result = array[size - 1];
        array[--size] = null;
        return result;
    }

    public Object peek() throws Excepcion {
        if (size == 0) {
            throw new Excepcion("Cannot peek into empty stack");
        }
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

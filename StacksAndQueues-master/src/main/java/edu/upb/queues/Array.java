/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.queues;

import edu.upb.models.IQueue;
import edu.upb.models.Excepcion;

/**
 *
 * @author cahuc
 */
public class Array implements IQueue {

    private final Object[] array;
    private int size = 0;
    private final int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added
    //with only tail or size its enough

    public Array(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public void enqueue(Object item) {
        if ( size >= array.length) {
            throw new Excepcion("Cannot add to full queue");
        } else {

            array[tail] = item;
            tail++;
            size++;
        }
    }

    @Override
    public Object dequeue() {
        if (size == 0) {

            throw new Excepcion("Cannot remove to empty queue");
        }
        Object item = array[head];
        for (int i = 0; i < tail - 1; i++) {//throught until one less than the last 

            array[i] = array[i + 1];//move to the head
        }
        size--;
        tail--;
        return item;
    }

    @Override
    public Object peek() {
        if (size == 0) {

            throw new Excepcion("Cannot remove to full queue");
        }
        Object item = array[tail - 1];
        return item;
    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}

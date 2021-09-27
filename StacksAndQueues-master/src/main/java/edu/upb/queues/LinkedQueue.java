/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.queues;

import edu.upb.models.IQueue;
import edu.upb.models.Excepcion;
import edu.upb.models.Node;

/**
 *
 * @author cahuc
 */
public class LinkedQueue implements IQueue {

    private Node head = null;
    private Node tail = null;
    private int size =0;

    
    @Override
    public void enqueue(Object item) {
        Node n = new Node(item);
        if(head==null){
        
            head=n;
            tail=head;
        }else{
            tail.setNext(n);
            tail=tail.getNext();
        }
        size++;
    }

    
    @Override
    public Object dequeue() {
        if(size==0){
        
            throw new Excepcion("cannor remove to empty queue");
        }
        Node item=head;
        head=head.getNext();
        size--;
        return item.getData();
        
    }

    
    @Override
    public Object peek() {
        if(size==0){
        
            throw new Excepcion("cannot peek empty queue");
        }
        Node item= head;
        return item.getData();
        
    }

    
    @Override
    public int size() {
        return size;
    }

    
    @Override
    public boolean isEmpty() {
        return size==0;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import edu.upb.models.MyException;
import edu.upb.queues.ArrayQueue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author vasqu
 */
public class ArrayQueueTest extends BaseQueueTest{
     private static final int CAPACITY = 40;

    @Before
    public void makeBoundedQueue() {
        s = new ArrayQueue(CAPACITY);
    }

    @Test(expected = MyException.class)
    public void testEnqueueToFullQueue() {
        
        for (int i = 0; i < CAPACITY; i++) {
            s.enqueue("Element "+i);
        }
        s.enqueue("abc");
    }
}

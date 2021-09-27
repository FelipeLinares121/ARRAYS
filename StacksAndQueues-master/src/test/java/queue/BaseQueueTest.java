/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;
import edu.upb.models.IQueue;
import edu.upb.models.MyException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author vasqu
 */
public abstract class BaseQueueTest {
    protected IQueue s;

    @Test
    public void testNewQueueIsEmpty() {
        assertTrue(s.isEmpty());
        assertEquals(s.size(), 0);
}
    @Test
    public void testEnqueueToEmptyQueue() {
        int numberOfPushes = 6;
        for (int i = 0; i < numberOfPushes; i++) {
            s.enqueue("zzz");
        }
        assertFalse(s.isEmpty());
        assertEquals(s.size(), numberOfPushes);
    }
    @Test
    public void testEnqueueDequeue() {
        int size=s.size();
        String message="zzz";
        s.enqueue(message);
        assertEquals(s.dequeue(), message);
        assertEquals(s.size(),size);//own
    }
    @Test
    public void testeEnqueueThenPeek(){
    
        String message="zzz";
        s.enqueue(message);
        int size=s.size();
        assertEquals(s.peek(),message);
        assertEquals(size,s.size());   
    }
    @Test
    public void testEnqueueThenDequeueToEmpty(){
    
        String message="zzz";
        int numberOfPushes=(int) (Math.random() * 10 + 1);//para que son los parentesis 
        for(int i=0;i< numberOfPushes;i++){
        
            s.enqueue(message);
        }
        for(int i=0;i< numberOfPushes;i++){
        
            s.dequeue();
        }
        assertTrue(s.isEmpty());
        assertEquals(s.size(),0);
    }
    @Test(expected = MyException.class)
    public void testDequeueEmptyQueue(){
    
        assertTrue(s.isEmpty());
        s.dequeue();
    }
    @Test(expected=MyException.class)
    public void testPeekEmptyQueue(){
    
        assertTrue(s.isEmpty());
        s.dequeue();
    }
}

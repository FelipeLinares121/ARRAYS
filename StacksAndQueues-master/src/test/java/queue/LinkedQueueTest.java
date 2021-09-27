/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import edu.upb.queues.LinkedQueue;
import org.junit.Before;

/**
 *
 * @author vasqu
 */
public class LinkedQueueTest extends BaseQueueTest{
    @Before
    public void makeLinkedStack() {
        s = new LinkedQueue();
    }

    
}

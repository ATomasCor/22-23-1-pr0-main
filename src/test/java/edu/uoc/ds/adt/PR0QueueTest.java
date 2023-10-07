package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0QueueTest {

    PR0Queue pr0q;



    private void fillQueue() {
        // Asignar fecha inicio y valor desplazamiento
        LocalDate date = LocalDate.of(2023,9,28);
        int scrolling = 2;

        for (int i = 0; i < pr0q.CAPACITY; i++) {
            pr0q.add(date);
            date = date.plusDays(scrolling);
        }
    }
    @Before
    public void setUp() {
        this.pr0q = new PR0Queue();

        assertNotNull(this.pr0q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr0q = null;
    }


    @org.junit.Test
    public void queueTest() {
        assertEquals(this.pr0q.CAPACITY, this.pr0q.getQueue().size());

        assertEquals(this.pr0q.clearFullQueue(), new String("28/09, 30/09, 02/10, 04/10, 06/10, 08/10, 10/10, 12/10, 14/10, 16/10"));

        assertEquals(0, this.pr0q.getQueue().size());
    }

}

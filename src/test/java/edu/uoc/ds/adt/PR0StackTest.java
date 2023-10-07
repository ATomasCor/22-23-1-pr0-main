package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0StackTest {

    PR0Stack pr0q;

    private void fillStack() {
        // Asignar fecha inicio y valor desplazamiento
        LocalDate date = LocalDate.of(2023,9,28);
        int scrolling = 2;

        for (int i=0; i< pr0q.CAPACITY; i++) {
            pr0q.push(date);
            date = date.plusDays(scrolling);
        }
    }

    @Before
    public void setUp() {
        this.pr0q = new PR0Stack();

        assertNotNull(this.pr0q.getStack());
        this.fillStack();

    }

    @After
    public void release() {
        this.pr0q = null;
    }


    @org.junit.Test
    public void stackTest() {

        assertEquals(this.pr0q.CAPACITY, this.pr0q.getStack().size());

        assertEquals(this.pr0q.clearAllStack(), new String("16/10, 14/10, 12/10, 10/10, 08/10, 06/10, 04/10, 02/10, 30/09, 28/09"));

        assertEquals(0, this.pr0q.getStack().size());
    }
}

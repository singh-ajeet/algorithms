package org.ajeet.learnings.algorithms.uf;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public final class UninFindTester {
    @Rule
    public ExpectedException m_expectedException = ExpectedException.none();;

    @Test
    public void constructor_invalidArgument1(){
        m_expectedException.expect(IllegalArgumentException.class);
        m_expectedException.expectMessage("Capacity should be greater than zero.");
        new UninFind(-1);
    }

    @Test
    public void constructor_invalidArgument2(){
        m_expectedException.expect(IllegalArgumentException.class);
        m_expectedException.expectMessage("Capacity should be greater than zero.");
        new UninFind(0);
    }

    @Test
    public void constructor(){
        UninFind uninFind = new UninFind(10);
        assertNotNull(uninFind);
    }

    @Test
    public void union_components(){
        UninFind uf = new UninFind(10);
        uf.union(1, 3);
        assertThat(9, is(uf.components()));
        uf.union(3, 4);
        assertThat(8, is(uf.components()));
        uf.union(4, 6);
        assertThat(7, is(uf.components()));
        uf.union(4, 6);
        assertThat(7, is(uf.components()));
        uf.union(7, 6);
        uf.union(2, 6);
        uf.union(2, 5);
        uf.union(8, 6);
        uf.union(9, 6);
        uf.union(10, 8);
        assertThat(1, is(uf.components()));
    }

    @Test
    public void union_find(){
        UninFind uf = new UninFind(10);
        uf.union(1, 3);
        assertThat(1, is(uf.find(3)));
        uf.union(3, 4);
        assertThat(1, is(uf.find(4)));
        uf.union(4, 6);
        assertThat(1, is(uf.find(6)));
    }

    @Test
    public void connected(){
        UninFind uf = new UninFind(10);
        uf.union(1, 3);
        assertTrue(uf.connected(1, 3));
    }
}

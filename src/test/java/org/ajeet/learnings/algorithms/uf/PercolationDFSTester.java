package org.ajeet.learnings.algorithms.uf;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class PercolationDFSTester {
    @Rule
    public ExpectedException m_expectedException = ExpectedException.none();

    @Test
    public void test_null(){
        m_expectedException.expect(IllegalArgumentException.class);
        m_expectedException.expectMessage("Input grid cant be null.");
        PercolationDFS.percolate(null);
    }

    @Test
    public void test1(){
        boolean[][] test1 =
                {{false, true, false},
                        {false, false, false},
                        {true, true, false}};
        assertTrue(PercolationDFS.percolate(test1));
    }

    @Test
    public void test2(){
        boolean[][] test2 =
                {{false, true, false},
                        {false, false, false},
                        {true, true, true}};
        assertFalse(PercolationDFS.percolate(test2));
    }

    @Test
    public void test3(){
        boolean[][] test3 =
                {{false, true, true},
                        {false, false, false},
                        {true, true, false}};
        assertTrue(PercolationDFS.percolate(test3));
    }

}

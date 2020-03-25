package org.ajeet.learnings.algorithms.linear;

import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;

public class StackArrayTester {

    @Rule
    public ExpectedException m_expectedException = ExpectedException.none();

    @Test
    public void construct_with_zero_capacity(){
        m_expectedException.expect(IllegalArgumentException.class);

        new StackArray<>(0);
    }

    @Test
    public void construct_with_negative_capacity(){
        m_expectedException.expect(IllegalArgumentException.class);

        new StackArray<>(-1);
    }

    @Test
    public void push_more_than_capacity(){
        m_expectedException.expect(ArrayIndexOutOfBoundsException.class);

        StackArray<Integer> stack = new StackArray<>(1);
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void pop(){
        StackArray<Integer> stack = new StackArray<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertThat(5, Is.is(stack.pop()));
    }
}

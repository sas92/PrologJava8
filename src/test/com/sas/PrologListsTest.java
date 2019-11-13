package com.sas;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author sas on 11/12/2019
 * @project Prolog99Problems
 */
public class PrologListsTest {

    private int result;

    @Test
    public void lastElementOfList() {
        String[] elements = {"A", "B", "C", "D"};
        List<String> listElements = Arrays.asList(elements);
        String result = PrologLists.lastElementOfList(listElements);
        assertEquals("D", result);

        LinkedList<String> linkedListElements = new LinkedList<String>(Arrays.asList(elements));
        result = PrologLists.lastElementOfList(linkedListElements);
        assertEquals("D", result);
    }

    @Test
    public void secondLastElementOfList() {
        String result = PrologLists.secondLastElementOfList(Arrays.asList("A", "B", "C", "D"));
        assertEquals("C", result);
    }

    @Test
    public void kthElementOfList() {
        String[] elements = {"A", "B", "C", "D"};
        int k = 1;
        List<String> listElements = Arrays.asList(elements);
        String result = PrologLists.kthElementOfList(listElements, k);
        assertEquals("B", result);

        LinkedList<String> linkedListElements = new LinkedList<String>(Arrays.asList(elements));
        result = PrologLists.kthElementOfList(linkedListElements, k);
        assertEquals("B", result);
    }

    @Test
    public void numberOfElements() {
        String[] elements = {"A", "B", "C", "D"};
        assertEquals(4,
                PrologLists.numberOfElements(Arrays.asList(elements)));
        assertEquals(4,
                PrologLists.numberOfElementsStream(Arrays.asList(elements)));
    }

    @Test
    public void reverseList() {
        List<String> elements = Arrays.asList("A", "B", "C", "D");
        LinkedList<String> linkedListElements = new LinkedList<>(elements);
        assertEquals(Arrays.asList("D", "C", "B", "A"),
                PrologLists.reverseList(elements));
        assertEquals(Arrays.asList("D", "C", "B", "A"),
                PrologLists.reverseList(linkedListElements));
    }

    @Test
    public void isPalindrome() {
        assertFalse(PrologLists.isPalindrome(Arrays.asList("A", "B", "C", "D")));
        assertTrue(PrologLists.isPalindrome(Arrays.asList("X", "A", "M", "A", "X")));
    }

    @Test
    public void flattenList() {
        List<String> flattenedList = PrologLists.flattenList(Arrays.asList("A",
                Arrays.asList("B",
                        Arrays.asList("C", "D"))));
        assertEquals(Arrays.asList("A", "B", "C", "D"), flattenedList);
    }
}
package com.sas;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sas on 11/12/2019
 * @project Prolog99Problems
 */
public class PrologLists {
    /*
    1.01 (*) Find the last element of a list.
    Example:
    ?- my_last(X,[a,b,c,d]).
    X = d
     */
    public static <T> T lastElementOfList(final List<T> elements) {          // List
        if (elements.isEmpty())
            throw new NoSuchElementException("List is empty");
        return elements.get(elements.size() - 1);
    }

    public static <T> T lastElementOfList(final LinkedList<T> elements) {    // Using LinkedList
        if (elements.isEmpty())
            throw new NoSuchElementException("List is empty");
        return elements.getLast();
    }

    /*
    1.02 (*) Find the last but one element of a list.
     */
    public static <T> T secondLastElementOfList(final List<T> elements) {
        if (elements.size() < 2)
            throw new NoSuchElementException("List has less than 2 elements");
        return elements.get(elements.size() - 2);
    }

    /*
    1.03 (*) Find the K'th element of a list.
    The first element in the list is number 1.
    Example:
    ?- element_at(X,[a,b,c,d,e],3).
    X = c
     */
    public static <T> T kthElementOfList(final List<T> elements, final int k) {         // Using List
        return elements.get(k);
    }

    public static <T> T kthElementOfList(final LinkedList<T> elements, final int k) {   // Using Stream
        return elements.stream()
                .limit(k + 1)
                .collect(Collectors.toCollection(LinkedList::new))
                .getLast();
    }

    /*
    1.04 (*) Find the number of elements of a list.
     */
    public static <T> int numberOfElements(final List<T> elements) {                    // Using List
        return elements.size();
    }

    public static <T> long numberOfElementsStream(final List<T> elements) {             // Using Stream
        return elements.stream().count();
    }

    /*
    1.05 (*) Reverse a list.
     */
    public static <T> List<T> reverseList(final List<T> elements) {                     // Using List
        Collections.reverse(elements);
        return elements;
    }

    public static <T> List<T> reverseList(final LinkedList<T> elements) {               // Using LinkedList
        LinkedList<T> reversed = new LinkedList<>();
        elements.forEach(element -> reversed.addFirst(element));
        return reversed;
    }

    /*
    1.06 (*) Find out whether a list is a palindrome.
    A palindrome can be read forward or backward; e.g. [x,a,m,a,x].
     */
    public static <T> boolean isPalindrome(final List<T> elements) {
        List<T> actual = new ArrayList<>(elements);
        Collections.reverse(elements);
        return Objects.equals(actual, elements);
    }

    /*
    1.07 (**) Flatten a nested list structure.
    Transform a list, possibly holding lists as elements into a 'flat' list by replacing each list with its elements (recursively).
    Example:
    ?- my_flatten([a, [b, [c, d], e]], X).
    X = [a, b, c, d, e]
    Hint: Use the predefined predicates is_list/1 and append/3
     */
    public static <T> List<T> flattenList(List<?> elements) {
        List<T> flattenedList = new ArrayList<>();
        elements.forEach(element -> {
            if (element instanceof List)
                flattenedList.addAll(flattenList((List<?>) element));
            else
                flattenedList.add((T)element);
        });
        return flattenedList;
    }

    public static void main(String[] args) {
    }
}

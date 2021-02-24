package com.bobobode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

/**
 * A class that consists of static methods only and provides util methods for {@link Node}.
 */
public class Nodes {
    private Nodes() {
    }

    /**
     * Creates a new instance of {@link Node} that holds provided element
     *
     * @param element any element of type T
     * @param <T>     generic type
     * @return a new instance of {@link Node}
     */
    public static <T> Node<T> create(T element) {
        Node<T> node = new Node<>();
        node.element = element;
        return node;
    }

    /**
     * Create a connection between first and second nodes, so object first stores a reference to the second.
     *
     * @param first  any {@link Node} object
     * @param second any {@link Node} object
     * @param <T>    a genetic type
     */
    public static <T> void link(Node<T> first, Node<T> second) {
        first.next = second;
    }

    /**
     * Creates two new {@link Node} objects using provided firstElement and secondElement, and create a connection
     * between those two elements so the first node will hold a reference to a second one.
     *
     * @param firstElement  any element of type T
     * @param secondElement any element of type T
     * @param <T>           a genetic type
     * @return a reference to a first node created based on firstElement
     */
    public static <T> Node<T> pairOf(T firstElement, T secondElement) {
        Node<T> first = new Node<>();
        Node<T> second = new Node<>();
        first.element = firstElement;
        second.element = secondElement;
        first.next = second;
        return first;
    }

    /**
     * Creates two new {@link Node} objects using provided firstElement and secondElement, and creates connections
     * between those nodes so the first node will hold a reference to a second one, and a second node will hold
     * a reference to the first one.
     *
     * @param firstElement  any element of type T
     * @param secondElement any element of type T
     * @param <T>           generic type T
     * @return a reference to the first node
     */
    public static <T> Node<T> closedPairOf(T firstElement, T secondElement) {
        Node<T> first = new Node<>();
        Node<T> second = new Node<>();
        first.element = firstElement;
        second.element = secondElement;
        first.next = second;
        second.next = first;
        return first;
    }

    /**
     * Creates a linked chain of {@link Node} objects based on provided elements. Creates a connection between those
     * nodes so each node will hold a reference to the next one in the chain. HINT: it's basically a linked list.
     *
     * @param elements a array of elements of type T
     * @param <T>      generic type T
     * @return a reference to the first element of the chain
     */
    public static <T> Node<T> chainOf(T... elements) {
        Node<T>[] chain = new Node[elements.length];
        for (int i = 0; i < chain.length; i++) {
            Node<T> node = new Node<>();
            node.element = elements[i];
            chain[i] = node;
        }

        for (int i = 0; i < chain.length - 1; i++) {
            chain[i].next = chain[i + 1];
        }

        return chain[0];
    }

    /**
     * Creates a linked circle of {@link Node} objects based on provided elements. Creates a connection between those
     * nodes so each node will hold a reference to the next one in the chain, and the last one will hold a reference to
     * the first one.
     *
     * @param elements a array of elements of type T
     * @param <T>      generic type T
     * @return a reference to the first element of the chain
     */
    public static <T> Node<T> circleOf(T... elements) {
        Node<T>[] chain = new Node[elements.length];
        for (int i = 0; i < chain.length; i++) {
            Node<T> node = new Node<>();
            node.element = elements[i];
            chain[i] = node;
        }

        for (int i = 0; i < chain.length; i++) {
            if (i == chain.length - 1) {
                chain[i].next = chain[0];
            } else {
                chain[i].next = chain[i + 1];
            }
        }

        return chain[0];
    }
}

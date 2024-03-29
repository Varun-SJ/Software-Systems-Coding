package ss.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
        // TODO: implement, see exercise P-4.9
    	Node newNode = new Node(element);
    	Node nodeatIndex = getNode(index);
    	newNode.next = nodeatIndex; 
        newNode.previous = nodeatIndex.previous;
        newNode.next.previous = newNode; 
        newNode.previous.next = newNode;

        this.size++;
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
        // TODO: implement, see exercise P-4.9

    	Node nodeatIndex = getNode(index);
    	Node prevNode = getNode(index-1);
    	prevNode.next = nodeatIndex.next;
    	nodeatIndex.next.previous = prevNode;
    	this.size--;
    	
    }
    
    
    
    
    

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}

package nl.hva.miw.ads.linkedlists;

import org.w3c.dom.Node;

/**
 * Singly linked list.
 *
 * @author Seyma Kanat
 */
public class SinglyLinkedList {

    private class Node {
        int value;

        Node next=null;      // Link to next node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node head = null;      // Link to first node liste henuz bos

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    /**
     * Return the value in the list at position index.
     *
     * @param index
     * @return
     */
    public int get( int index ) {
        // Check if index is valid (within list bounds)
        if ( index < 0 || index >= size ) {
            return Integer.MIN_VALUE;
        }
        // Now follow the next-pointer as many times as necessary to get to the node at requested index.
        Node current = head;
        for ( int i = 0; i < index; i++ ) {
            current = current.next;
        }
        return current.value;

    }

    /**
     * Add an element to the list at position index.
     *
     * @param index
     * @param value
     */
    public void add( int index, int value ) { //void olmali geri donusu olmasin diye
        // Check if index is valid (within list bounds, but could be one bigger (add a new element at the end of the list))
        if ( index < 0 || index > size ) {
            return;
        }
        Node newHead = new Node( value ); // Implement, create a new Node for this entry.
        size++;   // Don't forget to increment the size of the list

        // The simple case is if we add a new head (index == 0)
        if ( index == 0 ) {
            newHead.next = head; //yeni eleman eskinin basini isaret edecek
            head = newHead; //bas artik yeni elemani isaret ediyor
            return;
        } else {
            Node current = head;
            for ( int i = 0; i < index - 1; i++ ) {
                current = current.next;
            }
            Node newNode = new Node( value );
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Remove an elmeent from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove( int index ) {
        // Check if index is valid (within list bounds)
        if (index < 0 || index >= size){
            return;
        }

        // Decrease the size
        size--;

        // The simple case is if we remove the head (index == 0)
        if (index == 0) {
            // Set the new head to its successor
            head = head.next;
            return;
        }
        // Otherwise, follow the next-pointer as many times as necessary to get to the node at requested index,
        // but stop one entry before that!

            Node current = head;
        for ( int cnt=0; cnt < index - 1; cnt++ ) {
            current = current.next;
        }

        // Now remove the node after the current node, by simply bypassing it.
        current.next = current.next.next;
    }



    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("SinglyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }



}

package nl.hva.miw.ads.linkedlists;

/**
 * Doubly linked list.
 *
 * @author Seyma kanat
 */
public class DoublyLinkedList {

    private class Node {
        int value;

        Node next=null;      // Link to next node
        Node prev=null;      // Link to previous node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node head = null;      // Link to first node

    public DoublyLinkedList() {
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
            // Just return an insane number
            return Integer.MIN_VALUE;
        }
        // Now follow the next-pointer as many times as necessary to get to the node at requested index.
        Node current = head;
        for ( int cnt=0; cnt < index; cnt++ ) {
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
    public void add( int index, int value ) {
        // Check if index is valid (within list bounds, but could be one bigger (add a new element at the end of the list))
        if ( index < 0 || index > size ) {
            return;
        }
        // Implement, create a new Node for this entry.
        Node newNode = new Node( value );
        size++;

        // The simple case is if we add a new head (index == 0)
        if ( index == 0 ) {
            if( head != null ) { //TODO:Bu if blogu singleda yok
                head.prev = newNode;
            }
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for ( int cnt=0; cnt < index-1; cnt++ ) {
            current = current.next;
        }

        // Now insert the new node after the current
        newNode.next = current.next;
        newNode.prev = current;//TODO:Buda singleda yok
        // If there is a next node, then it should point back to this new node.
        if ( newNode.next != null ) {//TODO:Bu if blogu singleda yok
            newNode.next.prev = newNode;
        }
        current.next = newNode;

        }





    /**
     * Remove an elmeent from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove( int index ) {
        // Check if index is valid (within list bounds)
        if (index < 0 || index >= size) {
            return;
        }
        // Decrease the size. Baglantinin boyutunu azaltir.
        size--;

        // Follow the next-pointer as many times as necessary to get to the node at requested index
        Node current = head;
        for ( int cnt=0; cnt < index - 1; cnt++ ) {
            current = current.next;
        }

        // Now remove the node after the current node, by simply bypassing it.
        if (current.prev != null) { // Removing the Node:
            current.prev.next = current.next;
        }

        if (current.next != null) {// Removing the Node:
            current.next.prev = current.prev;
        }
        // Check if we removed the head
        if ( index == 0 ) { //Kaldırılan düğüm listenin başıysa (dizin 0'dır), başlığı bir sonraki düğüme günceller.
            head = current.next;
        }
    }



    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("DoublyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }



}

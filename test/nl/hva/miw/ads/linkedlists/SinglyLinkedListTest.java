package nl.hva.miw.ads.linkedlists;

import org.junit.Test;
import org.w3c.dom.Node;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void add() {
        SinglyLinkedList list = new SinglyLinkedList();


        list.add(0, 400);
        list.add(0, 100);
        list.add(1, 200);
        list.add(2, 300);
        list.add(4, 500);


        String expected = "SinglyLinkedList{size=5} 100 200 300 400 500";
        String actual = list.toString();
        assertEquals(expected, actual);

        list.printList();
    }




    @Test
    public void remove() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(0, 400);
        list.add(0, 100);
        list.add(1, 200);
        list.add(2, 300);
        list.add(4, 500);

        list.remove( 0 );
        String expected = "SinglyLinkedList{size=4} 200 300 400 500";
        String actual = list.toString();
        assertEquals(expected, actual);

        list.printList();

    }

}
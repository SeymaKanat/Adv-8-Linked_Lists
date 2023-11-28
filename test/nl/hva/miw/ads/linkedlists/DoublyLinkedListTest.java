package nl.hva.miw.ads.linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListTest {

    @Test
    public void add() {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("Initial List: " + list);

        list.add(0, 400);
        list.add(0, 100);
        list.add(1, 200);
        list.add(2, 300);
        list.add(4, 500);


        String expected = "DoublyLinkedList{size=5} 100 200 300 400 500";
        String actual = list.toString();

        System.out.println("Final List: " + actual);

        assertEquals(expected, actual);

    }

    @Test
    public void remove() {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(0, 400);
        list.add(0, 100);
        list.add(1, 200);
        list.add(2, 300);
        list.add(4, 500);
        System.out.println("Initial List: " + list);

        list.remove( 0 );
        String expected = "DoublyLinkedList{size=4} 200 300 400 500";
        String actual = list.toString();

        System.out.println("Final List: " + actual);

        assertEquals(expected, actual);

//        list.remove( 3 );
//        expected = "DoublyLinkedList{size=3} 200 300 400";
//        actual = list.toString();
//        assertEquals(expected, actual);

//        list.remove( 1 );
//        expected = "DoublyLinkedList{size=2} 200 400";
//        actual = list.toString();
//        assertEquals(expected, actual);
//
//        list.remove( 1 );
//        expected = "DoublyLinkedList{size=1} 200";
//        actual = list.toString();
//        assertEquals(expected, actual);
//
//        list.remove( 0 );
//        expected = "DoublyLinkedList{size=0}";
//        actual = list.toString();
//        assertEquals(expected, actual);
    }
}
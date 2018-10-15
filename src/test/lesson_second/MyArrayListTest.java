package lesson_second;

import org.junit.Before;
import org.junit.Test;
import ru.interview.lesson_second.MyArrayList;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 15.10.2018
 */
public class MyArrayListTest {

    private MyArrayList<String> myList;

    @Before
    public void fillList() {
        myList = new MyArrayList<>();
        for (int i = 1; i < 12; i++) {
            myList.add(Integer.toString(i));
        }
    }

    @Test
    public void addElevenElements() {
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Empty: " + myList.isEmpty() + ", size: " + myList.size());
    }

    @Test
    public void getElements() {
        assertThat(myList.get("11"), is(10));
        assertThat(myList.get(1), is("2"));
        assertThat(myList.get("12"), is(-1));
        assertNull(myList.get(12));
    }

    @Test
    public void whenContainAndDeleteThenTrue() {
        assertTrue(myList.contain("5"));
        System.out.println(myList.size());
        myList.remove("5");
        System.out.println(myList.size());
        assertFalse(myList.contain("5"));
    }
}

package lesson_second;

import java.util.Iterator;
import org.junit.Test;
import ru.interview.lesson_second.MyLinkedList;

/**
 * @author Valeriy Gyrievskikh
 * @since 15.10.2018
 */
public class MyLinkedListTest {

    @Test
    public void addAndGetElements(){
        MyLinkedList<String> myList = new MyLinkedList<>();
        for (int i = 0; i < 12; i++) {
            myList.add(Integer.toString(i));
        }
        System.out.println(myList.get(5));
        System.out.println(myList.contain("8"));
        System.out.println(myList.size());
        myList.remove("8");
        System.out.println(myList.contain("8"));
        System.out.println(myList.size());
        Iterator<String> iterator = myList.iterator();
        System.out.println(iterator.next());
    }
}

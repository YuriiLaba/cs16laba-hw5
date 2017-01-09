package ua.edu.ucu;

import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntUnaryOperator;
import ua.edu.ucu.stream.*;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;

import java.util.Arrays;

/**
 *
 * @author andrii
 */
public class StreamAppTest {

    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }

    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamAverage() {
        int[] list = {-1,1,2,3,4,5};
        Double expResult = 2.0d;
        Double result = AsIntStream.of(list).average();
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamMax() {
        int[] list = {-1,1,2,3,4,5};
        int expResult = 5;
        int result = AsIntStream.of(list).max();
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamMin() {
        int[] list = {-1,1,2,3,4,5};
        int expResult = -1;
        int result = AsIntStream.of(list).min();
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamCount() {
        int[] list = {-1,1,2,3,4,5};
        long expResult = 6;
        long result = AsIntStream.of(list).count();
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamSum() {
        int[] list = {-1,1,2,3,4,5};
        int expResult = 14;
        long result = AsIntStream.of(list).sum();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamFilter() {
        int[] list = {-1,1,2,3,4,5};
        IntPredicate nw1  = value -> (value>2);
        String expResult = "[3, 4, 5]";
        String result = Arrays.toString(AsIntStream.of(list).filter(nw1).toArray());
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamMap() {
        int[] list = {-1,1,2,3,4,5};
        IntUnaryOperator mapp = operand -> operand-1;
        String expResult = "[-2, 0, 1, 2, 3, 4]";
        String result = Arrays.toString(AsIntStream.of(list).map(mapp).toArray());
        assertEquals(expResult, result);
    }


}

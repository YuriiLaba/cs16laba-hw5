package ua.edu.ucu.stream;

import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Arrays;

/**
 * Created by jlaba on 08.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        int[] nw = {-1,1,2,3,4,5};
        System.out.println(AsIntStream.of(nw).count());
        System.out.println(AsIntStream.of(nw).sum());
        System.out.println(AsIntStream.of(nw).max());
        System.out.println(AsIntStream.of(nw).min());
        System.out.println(AsIntStream.of(nw).average());
        //System.out.println(AsIntStream.of(nw).filter(2));

        IntPredicate nw1  = value -> (value>2);

        IntUnaryOperator mapp = operand -> operand-1;



        AsIntStream.of(nw).toArray();


        System.out.println(Arrays.toString(AsIntStream.of(nw).filter(nw1).toArray()));




    }
}

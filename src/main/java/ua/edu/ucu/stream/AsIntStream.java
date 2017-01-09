package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;


public class AsIntStream implements IntStream {

    public ArrayList<Integer> arrayList;

    private AsIntStream() {
        this.arrayList = new ArrayList<>();
    }

    public static IntStream of(int... values) {
        AsIntStream asIntStream = new AsIntStream();

        for(int element:values){
            asIntStream.arrayList.add(element);

        }System.out.println(asIntStream.arrayList);
        return asIntStream;
    }

    @Override
    public Double average() {
        return (double) (sum() / count());
    }

    @Override
    public Integer max() {
        int max = 0;
        IntBinaryOperator operator = (left, right) -> {
            if (left > right) {
                return left;
            }else{
                return right;
            }
        }; return reduce(max, operator);
    }

    @Override
    public Integer min() {
        int max = 0;
        IntBinaryOperator operator = (left, right) -> {
            if (left < right) {
                return left;
            }else{
                return right;
            }
        }; return reduce(max, operator);
    }

    @Override
    public long count() {
        return arrayList.size();
    }


    @Override
    public Integer sum() {
        int sumOfTheList = 0;
        IntBinaryOperator operator = (left, right) -> {
            left += right;
            return left;
        }; return reduce(sumOfTheList, operator);
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        AsIntStream resultList = new AsIntStream();
        for (int i: arrayList) {
            if (predicate.test(i)) {
                resultList.arrayList.add(i);
            }
        }
        return resultList;
    }

    @Override
    public void forEach(IntConsumer action) {
        for(Object element: arrayList){
            action.accept((Integer) element);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        AsIntStream asIntStream = new AsIntStream();
        arrayList.forEach(x -> asIntStream.arrayList.add(mapper.apply(x)));
        return asIntStream;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<Integer> temp = new ArrayList<>();
        forEach(
                x -> {
                    AsIntStream ar = (AsIntStream)func.applyAsIntStream(x);
                    IntConsumer action = temp::add;
                    ar.forEach(action);
                });

        int[] array = new int[temp.size()];
        for (int i=0; i<temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return of(array);    }

    @Override
    public int reduce(int identity, IntBinaryOperator operator) {
        int result = identity;
        for (int element:arrayList){
            result = operator.apply(result, element);

        }return result;

    }

    @Override
    public int[] toArray() {
        int[] integerArray = new int[(int)count()];
        for (int i=0; i<(int)count(); i++) {
            integerArray[i] = arrayList.get(i);
        }
        return integerArray;
    }

}

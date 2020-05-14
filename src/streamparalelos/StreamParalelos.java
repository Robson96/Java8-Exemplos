package streamparalelos;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class StreamParalelos {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        //Imprimi fora de ordem
        list.parallelStream().forEach(System.out::println);
        System.out.println("===========");
        //Imprimi na ordem
        list.parallelStream().forEachOrdered(System.out::println);

        //onurdered
        System.out.println("===================");
        list.parallelStream()
                //use sempre que for usar
                //skip() ou limit()
                .unordered()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("===================");
        // toMap
        //Em vez de por exe: 4 threads criar um map para cada
        //O toConcurrentMap() criar um unico map para as 4 threads
        ConcurrentMap<Integer, Integer> concurrentMap = list.parallelStream()
                .collect(Collectors.toConcurrentMap((k) -> k, (v) -> v * 10));
        System.out.println(concurrentMap);

        System.out.println("===================");

        //Grouping
        ConcurrentMap<Boolean, List<Integer>> collect = list.parallelStream()
                .collect(Collectors.groupingByConcurrent((n) -> n % 2 == 0));
        System.out.println(collect);
    }
}

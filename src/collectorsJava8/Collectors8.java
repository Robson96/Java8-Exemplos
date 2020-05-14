package collectorsJava8;

import streamspt2.Pessoa;

import java.text.NumberFormat;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Collectors8 {
    public static void main(String[] args) {
        var list = Arrays.asList(100, 20, 3, 10, 5, 6, 7, 8, 9, 0, 10, 20, 49, 55);

        var collect = list.stream()
                //fornecedor - acumulacao  - combinacao
                //  supplier - accumulator - combiner
                .map(e -> e * 2)
                .collect(ArrayList::new, (l, e) -> l.add(e), (l1, l2) -> l1.addAll(l2));
        //System.out.println(collect);

        //toList
        var l = list.stream().collect(Collectors.toList());

        // toSet
        var set = list.stream()
                .collect(Collectors.toSet());
        System.out.println(set);

        // toCollection
        LinkedList<Integer> linkedList = list.stream()
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println(linkedList.getLast());

        // toJoining
        var s = linkedList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ", "\"", "\""));
        System.out.println(s);

        //averaging
        Double mediaDouble = linkedList.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.printf("%.2f\n", mediaDouble);

        //summing
        Integer somaInteger = list.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println(somaInteger);

        int sum = linkedList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //summarizing
        IntSummaryStatistics statistics = list.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("statistics");
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Total de Elementos: " + statistics.getCount());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Soma: " + statistics.getSum());

        // partitioningBy
        Map<Boolean, List<Integer>> booleanListMap = linkedList.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 != 0));
        System.out.println("numeros -> Pares/Impares");
        System.out.println(booleanListMap);

        // toMap
        List<Pessoa> pessoas = Pessoa.getPessoas();
        Map<String, Integer> map = pessoas.stream()
                //                        Key(chave), value(valor)
                .collect(Collectors.toMap(Pessoa::getNome, Pessoa::getIdade));
        System.out.println(map);

        /*BiFunction<String, Integer, Pessoa> factory = Pessoa::new;
        Pessoa pessoa = factory.apply("robson", 20);*/
    }
}

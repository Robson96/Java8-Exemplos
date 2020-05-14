/**
 * O Reduce é sempre para se trabalhar com objs IMUTAVEIS
 * ja o collect pode se trabalhar com os dois estados
 * IMUTAVEIS, MUTAVEIS
 */
package reducejava8;

import streamspt2.Pessoa;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class JavaReduce {
    public static void main(String[] args) {
        String s = "Github para devs!";
        String[] palavras = s.split(" ");

        List<String> listPl = Arrays.asList(palavras);
        var list = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> soma = list.stream().reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());

        Integer soma2 = list.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma2);

        var muilt = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(muilt);

        String optionalPl = listPl.stream()
                .reduce("", (s1, s2) -> s1.concat(" " + s2));
        System.out.println(optionalPl);

        var min = DoubleStream.of(1.3, 1.5, 6.0)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(min);

        var soma3 = listPl.stream()
                .reduce(
                        "",
                        (n1, n2) -> n1.concat(n2),
                        (n1, n2) -> n1.concat(n2)
                );
        System.out.println(soma3);

        int valorIniacial = 0;
        IntBinaryOperator operacao = (a, b) -> a + b;
        int reduce = IntStream.range(1, 10)
                .reduce(valorIniacial, operacao);
        System.out.println(reduce);

        var pessoas = Arrays.asList(
                new Pessoa("rob", 20),
                new Pessoa("maag", 15),
                new Pessoa("swd", 80)
        );

        Integer somaTodos = pessoas.stream()
                .reduce(0, (atual, p) -> atual + p.getIdade(), Integer::sum);
        System.out.println(somaTodos);
    }
}

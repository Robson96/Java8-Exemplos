package streamspt2;

import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamPt2 {
    public static void main(String[] args) {
        var list = Arrays.asList(1, 8, 10, 4, 5, 6, 10, 2, 20);
        var pessoas = Arrays.asList(
                new Pessoa("Robson", 20),
                new Pessoa("Magno", 10),
                new Pessoa("Gomes", 15),
                new Pessoa("Silva", 18),
                new Pessoa("Silvana", 20));

        Optional<Integer> min = list.stream().max(Comparator.comparingInt(Integer::intValue));
        System.out.println(min.get());

        var list2 = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        list2.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(list2);

        Map<Integer, List<Integer>> mapa = list.stream()
                .collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(mapa);

        Map<Boolean, List<Pessoa>> grupoPessoas = pessoas.stream()
                .collect(Collectors.groupingBy(p -> p.getIdade() >= 18));
        System.out.println(grupoPessoas);

        //Agrupar pelo as iniciais do nome
        Map<Character, List<Pessoa>> nomes = pessoas.stream()
                .collect(Collectors.groupingBy(p -> p.getNome().charAt(0)));
        System.out.println(nomes);
        String numeros =
                list.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";,", "", ";"));
        //System.out.println(numeros);

        /*CharSequence charSequence = "robson";
        CharSequence charSequence3 = "robson";
        CharSequence charSequence1 = new StringBuffer("teste");
        CharSequence charSequence2 = new StringBuilder("teste1");
        var b = charSequence.equals(charSequence3);
        */
    }
}

package streamspt1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Java8StreamPt1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6);
        list.stream()
                //.skip(2) pula x elementos da lista
                //.distinct() nao processa o elemento repetido da lista, equels() e hashCode() tem que ta impl
                //.filter(i -> i % 2 != 0) frilta os elementos da lista de acordo com o predicate
                //**********************************************************************
                //E recomendavel sempre limitar o numero de elementos que vai ser processado por
                // qualquer operaçao intermediaria do stream
                // por exemplo se a lista for muito grande
                .limit(2) //limita o processamento a x elementos da lista
                .map(i -> i * i) //transforma o elemento da lista x -> y
                .forEach(i -> System.out.println(i));
    }
}

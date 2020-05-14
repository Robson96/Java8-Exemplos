package collectionjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CollectionsJava8 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeIf(n -> n == 3);
        list.forEach(e -> System.out.println(e));
        System.out.println("================");
        list.replaceAll(n -> n * 2);
        list.forEach(System.out::println);

        //Mapa
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "robson");
        map.put(2, "magno");

        map.compute(1, (k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println(k + v));

        map.merge(2, "!", (vOld, vNew) -> vOld + vNew);
        map.forEach((k, v) -> System.out.println(k + v));




        //O metodo estatico asList()
        //Retorna uma ArrayList do pacote
        //java.util.Arrays.ArrayList
        //entao esse tipo de classe nao aceita operacoes de
        //add() ou remove(), e seu tamanho é fixo
        //de acordo com a quantidades de parametros
        //passados no metodo!
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        //System.out.println(integers.get(0)); // OK
        //integers.add(1); Exeption
        //integers.remove(1); Exeption

    }
}

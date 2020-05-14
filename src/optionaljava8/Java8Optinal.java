package optionaljava8;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntConsumer;

public class Java8Optinal {
    public static void main(String[] args) {
        String n = "1";

        converteNumero(n).ifPresent(i -> System.out.println(i));
        System.out.println(converteNumero(n).orElse(4));
        var v = converteNumero(n).orElseGet(() -> 4);
        System.out.println(v);
        converteNumero(n).orElseThrow(() -> new NullPointerException());

        int i = somaUm("2").getAsInt();
        System.out.println(i);
    }

    private static Optional<Integer> converteNumero(String n) {
        try {
            //O metodo of() nao pode receber um valor null
            // Ja o metodo ofNullable() pode receber valor null
            return Optional.ofNullable(Integer.valueOf(n));
            //return Optional.of(Integer.valueOf(n));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Todo @see Optional<T> tem um para tipos primitivos
     * 
     * @param n
     * @return @see OptionalInt
     */
    public static OptionalInt somaUm(String n) {
        return OptionalInt.of(Integer.parseInt(n) + 1);
    }
}

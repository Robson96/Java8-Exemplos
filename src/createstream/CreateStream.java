package createstream;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //Arrays
        Integer[] ints = new Integer[] {1, 2, 3, 4, 5, 6};
        //Arrays.stream(ints).forEach(System.out::println);

        //Stream.of
        Stream.of("1", 2, "casa", 4).forEach(e -> System.out.println(e));

    }
}

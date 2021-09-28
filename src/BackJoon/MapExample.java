package BackJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {
        List<List<String>> tt = new ArrayList<>();
        Stream<String> strStream = Stream.of("Hello","World");

         List<String> dd = strStream.map(s-> s.split(""))
                 .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        for (String string : dd) {
            System.out.print(string);
        }
    }
}

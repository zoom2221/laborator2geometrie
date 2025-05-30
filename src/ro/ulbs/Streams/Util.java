package ro.ulbs.Streams;

// Java
import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = random.ints(10, 5, 26) // Generează 10 numere în intervalul [5, 25]
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Lista generată: " + numbers);

        // a)
        int sum = numbers.stream().reduce(0, Integer::sum); // Sau numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("a) Suma elementelor listei: " + sum);

        // b)
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("b) Valoarea maximă: " + max.orElse(null));
        System.out.println("b) Valoarea minimă: " + min.orElse(null));

        // c)
        List<Integer> filteredList = numbers.stream()
                .filter(num -> num >= 10 && num <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Lista elementelor în intervalul [10, 20]: " + filteredList);

        // d)
        List<Double> doubleList = numbers.stream()
                .map(num -> num.doubleValue())
                .collect(Collectors.toList());
        System.out.println("d) Lista transformată în Double: " + doubleList);

        // e)
        boolean contains12 = numbers.stream().anyMatch(num -> num == 12);
        System.out.println("e) Există valoarea 12 în lista? " + contains12);



        List<Integer> initialList = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

        List<Integer> squares = initialList.stream()
                .distinct()
                .map(num -> num * num)
                .collect(Collectors.toList());
        System.out.println("9.3.2) Lista pătratelor valorilor distincte: " + squares);


        String sentence = "Acesta este un program scris cu java 8 si expresii lambda";
        List<String> words = Arrays.asList(sentence.split(" "));

        // a2)
        List<String> longWords = words.stream()
                .filter(word -> word.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("9.3.3.a) Lista cuvintelor cu lungime >= 5: " + longWords);
        System.out.println("9.3.3.a) Numărul de cuvinte cu lungime >= 5: " + longWords.size());
    }
}

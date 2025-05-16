package ro.ulbs.da;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> randomNumbers = new Random()
                .ints(10, 5, 26)
                .boxed()
                .collect(Collectors.toList());


        int sum = randomNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();


        int max = randomNumbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new RuntimeException("Lista este goală"));


        int min = randomNumbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new RuntimeException("Lista este goală"));


        List<Integer> filteredNumbers = randomNumbers.stream()
                .filter(num -> num >= 10 && num <= 20)
                .collect(Collectors.toList());


        System.out.println("Lista de numere generate: " + randomNumbers);
        System.out.println("Suma elementelor: " + sum);
        System.out.println("Valoarea maxima: " + max);
        System.out.println("Valoarea minima: " + min);
        System.out.println("Lista de numere filtrate intre intervalul 10 si 20: " + filteredNumbers);
    }
}
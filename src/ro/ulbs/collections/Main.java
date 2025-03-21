package ro.ulbs.collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Inițializare liste și set
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();


        Random rand = new Random();


        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11)); // Numere între 0 și 10
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11)); // Numere între 0 și 10
        }


        Collections.sort(x);
        Collections.sort(y);


        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);


        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("zSet (comune): " + zSet);


        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("xMinusY (din x dar nu în y): " + xMinusY);


        xPlusYLimitedByP.addAll(x);
        xPlusYLimitedByP.addAll(y);
        xPlusYLimitedByP.removeIf(e -> e > p);
        Collections.sort(xPlusYLimitedByP);


        System.out.println("xPlusY (toate elementele): " + xPlusY);
        System.out.println("xPlusYLimitedByP (elementele <= p): " + xPlusYLimitedByP);
    }
}

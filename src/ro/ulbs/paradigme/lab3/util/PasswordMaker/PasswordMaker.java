package ro.ulbs.paradigme.lab3.util.PasswordMaker;

import java.util.Random;

public class PasswordMaker extends StringRandomizer {
    private static final int MAGIC_NUMBER = new Random().nextInt(6) + 5;
    private final String magicString;
    private final String name;

    public PasswordMaker(String name) {
        this.name = name;
        this.magicString = StringRandomizer.getRandomString(20);
    }

    public String getPassword() {
        Random random = new Random();
        String randomPart = StringRandomizer.getRandomString(MAGIC_NUMBER);
        String magicPart = magicString.substring(0, 10);
        String nameLength = String.valueOf(name.length());
        int randomNumber = random.nextInt(51);

        return randomPart + magicPart + nameLength + randomNumber;
    }

    public static void main(String[] args) {
        PasswordMaker pm = new PasswordMaker("LionelMersii");
        System.out.println("Parola generată: " + pm.getPassword());
    }
}


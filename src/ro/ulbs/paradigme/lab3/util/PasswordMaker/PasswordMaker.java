package ro.ulbs.paradigme.lab3.util.PasswordMaker;

import java.util.Random;

public class PasswordMaker extends StringRandomizer {
    private static final int MAGIC_NUMBER = new Random().nextInt(6) + 5;
    private final String magicString;
    private final String name;
    private static PasswordMaker instance;
    private static int instanceAccessCount = 0;

    private PasswordMaker(String name) {
        this.name = name;
        this.magicString = StringRandomizer.getRandomString(20);
    }

    public static synchronized PasswordMaker getInstance(String name) {
        if (instance == null) {
            instance = new PasswordMaker(name);
        }
        instanceAccessCount++;
        return instance;
    }

    public String getPassword() {
        Random random = new Random();
        String randomPart = StringRandomizer.getRandomString(MAGIC_NUMBER);
        String magicPart = magicString.substring(0, 10);
        String nameLength = String.valueOf(name.length());
        int randomNumber = random.nextInt(51);

        return randomPart + magicPart + nameLength + randomNumber;
    }

    public static int getInstanceAccessCount() {
        return instanceAccessCount;
    }

    public static void main(String[] args) {
        PasswordMaker pm1 = PasswordMaker.getInstance("Mersi");
        System.out.println("Parola pt mersi: " + pm1.getPassword());

        PasswordMaker pm2 = PasswordMaker.getInstance("Rolando");
        System.out.println("Parola pt rolando: " + pm2.getPassword());

        PasswordMaker pm3 = PasswordMaker.getInstance("Dis");
        System.out.println("Parola pt dis: " + pm3.getPassword());

        System.out.println("Metoda getInstance() a fost accesată de " + PasswordMaker.getInstanceAccessCount() + " ori.");
    }
}


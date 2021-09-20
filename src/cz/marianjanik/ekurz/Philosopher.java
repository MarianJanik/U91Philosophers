package cz.marianjanik.ekurz;

import java.text.DecimalFormat;

public class Philosopher extends Thread {
    private String name;
    private Fork forkInLeftHand;
    private Fork forkInRightHand;

    private final int NUMBER_OF_SERVINGS = 10000;

    public Philosopher(String name, Fork forkInLeftHand, Fork forkInRightHand) {
        this.name = name;
        this.forkInLeftHand = forkInLeftHand;
        this.forkInRightHand = forkInRightHand;
    }

    @Override
    public synchronized void run() {
        DecimalFormat myFormat = new DecimalFormat("#,###");
        int counter = 1;
        while (counter<=NUMBER_OF_SERVINGS) {
            synchronized (forkInLeftHand) {    // nevidím rozdíl s tím řádkem nebo bez
                System.out.println(name + " - left hand");
                synchronized (forkInRightHand) {
                    System.out.println(name + " - right hand");
                    System.out.println(name + ": Yes! I can chew " + myFormat.format(counter) + " times.");
                    counter++;
                }
            }
        }
    }
}
package cz.marianjanik.ekurz;

public class Main {

    public static void main(String[] args) {

        Fork[] forks = new Fork[10];
        for (int i = 0; i < 10; i++) {
            forks[i] = new Fork("Fork " + i);
        }

        Philosopher[] philosopher = new Philosopher[10];
        for (int i = 0; i < 9; i++) {
            philosopher[i] = new Philosopher("Folozof " + i,forks[i],forks[i+1]);
        }
        philosopher[9] = new Philosopher("Filozof 9",forks[0],forks[9]);

        for (Philosopher person : philosopher) {
            person.start();
        }

//        for (Fork fork : forks) {
//            System.out.println(fork.getName());
//        }
//
//        for (Philosopher person : philosopher) {
//            System.out.println(person.getName());
//        }
    }
}

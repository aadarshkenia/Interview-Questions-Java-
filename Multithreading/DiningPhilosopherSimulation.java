package Threading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopherSimulation {
    private Lock lock = new ReentrantLock();
    private final int SIZE = 5;
    private boolean chopsticks[] = new boolean[SIZE]; //true indicates available.
    private Random random = new Random();

    public DiningPhilosopherSimulation() {
        for(int i = 0; i < SIZE; i++) {
            chopsticks[i] = true;
        }
    }


    public void start() {
        Philosopher philosophers[] = new Philosopher[SIZE];
        for(int i=0; i < SIZE; i++) {
            philosophers[i] = new Philosopher(i);
        }
        for(int i=0; i < SIZE; i++) {
            new Thread(philosophers[i]).start();
        }
    }

    public static void main(String args[]) {
        DiningPhilosopherSimulation simulation = new DiningPhilosopherSimulation();
        simulation.start();
    }

    class Philosopher implements Runnable {
        private int index;

        @Override
        public void run() {
            try {
                think();
                Thread.sleep((long)(random.nextDouble() * 1000));
                eat();
                Thread.sleep((long)(random.nextDouble() * 1000));
                think();
                Thread.sleep((long)(random.nextDouble() * 1000));
                eat();
                Thread.sleep((long)(random.nextDouble() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        public Philosopher(int index) {
            this.index = index;
        }
        public void eat() {
            try {
                System.out.println(String.format("Philosopher [%d] attempting to eat.", index));
                boolean eaten = false;
                while(!eaten) {
                    try {
                        lock.lock();
                        boolean leftChopstick = chopsticks[left()];
                        boolean rightChopstick = chopsticks[right()];
                        if(leftChopstick && rightChopstick) {
                            chopsticks[left()] = false;
                            chopsticks[right()] = false;
                            System.out.println(String.format("Philosopher [%d] eating using left : %d and right : %d chopsticks.", index, left(), right()));
                            eaten = true;
                        } else {
                            System.out.println(String.format("Chopsticks not available for philosopther [%d]", index));
                        }
                    } finally {
                        lock.unlock();
                    }

                    try {
                        if(!eaten) {
                            Thread.sleep(1000);  //Sleep for 1 second before trying to eat again.
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread.sleep((long)(random.nextDouble() * 3000)); //Equivalent to time taken for eating.
                try {
                    lock.lock();
                    chopsticks[left()] = true;
                    chopsticks[right()] = true;
                    System.out.println(String.format("Philosopher [%d] has finished eating.", index));
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

        //Think for a random amount of time between 1 - 3 seconds
        public void think() {
            try {
                System.out.println("Philosopher [" + index + "] is thinking.");
                Thread.sleep((long)(random.nextDouble() * 3000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }

        private int left() {
            return index;
        }

        private int right() {
            return (index + SIZE - 1) % SIZE;
        }


    }

}


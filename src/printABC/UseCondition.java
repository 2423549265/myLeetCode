package printABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseCondition {
    static class PrintABC {
        private Lock lock;
        private Condition conditionA, conditionB, conditionC;
        private int state;

        public PrintABC() {
            lock = new ReentrantLock();
            conditionA = lock.newCondition();
            conditionB = lock.newCondition();
            conditionC = lock.newCondition();
            state = 0;
        }

        public void printA() throws InterruptedException {
            if (state % 3 != 0) {
                conditionA.await();
            }
            System.out.println("A");
            state ++;
            conditionB.signal();
        }

        public void printB() throws InterruptedException {
            if (state % 3 != 1) {
                conditionB.await();
            }
            System.out.println("B");
            state ++;
            conditionC.signal();
        }

        public void printC() throws InterruptedException {
            if (state % 3 != 2) {
                conditionC.await();
            }
            System.out.println("C");
            state ++;
            conditionA.signal();
        }
    }

    public static void main(String[] args) {
        UseSemaphore.PrintABC printABC = new UseSemaphore.PrintABC();
        Thread threadA = new Thread(() -> {
            while (true) {
                printABC.printA();
            }
        });
        Thread threadB = new Thread(() -> {
            while (true) {
                printABC.printB();
            }
        });
        Thread threadC = new Thread(() -> {
            while (true) {
                printABC.printC();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

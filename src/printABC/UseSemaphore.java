package printABC;

import java.util.concurrent.Semaphore;

public class UseSemaphore {
    static class PrintABC {
        private Semaphore semaphoreA, semaphoreB, semaphoreC;

        public PrintABC() {
            semaphoreA = new Semaphore(1);
            semaphoreB = new Semaphore(0);
            semaphoreC = new Semaphore(0);
        }

        public void printA() {
            try {
                semaphoreA.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("A");
            semaphoreB.release();
        }

        public void printB() {
            try {
                semaphoreB.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("B");
            semaphoreC.release();
        }

        public void printC() {
            try {
                semaphoreC.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("C");
            semaphoreA.release();
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
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

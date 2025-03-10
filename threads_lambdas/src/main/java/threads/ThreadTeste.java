package threads;

class ThreadExample extends Thread {
    private char c;

    public ThreadExample(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(" "+Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            System.out.print(c);
            if(i % 100 == 0) System.out.println();
        }
    }
}

public class ThreadTeste {
    public static void main(String[] args) {
       ThreadExample t1 = new ThreadExample('a');
       ThreadExample t2 = new ThreadExample('b');
       ThreadExample t3 = new ThreadExample('c');
       ThreadExample t4 = new ThreadExample('d');

       t1.start();
       t2.start();
       t3.start();
       t4.start();
    }




}

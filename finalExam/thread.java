package finalExam;

public class thread
{
    private static int zero;
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread1 = new Thread(new Runnable() { @Override
        public void run() {
            for (int i = 0; i < 100000; i++)
                zero++;  }  });
        Thread thread2 = new Thread(new Runnable() { @Override
        public void run() {
            for (int i = 0; i < 100000; i++)
                zero--;
        }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Zero: " + zero);
    }
}

package day04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedServerMain {

   public static void main(String[] args) {

      // Create a fixed thread pool
      ExecutorService thrPool = Executors.newFixedThreadPool(2);

      for (int i = 0; i < 10; i++) {
         // Create a work for the thread to perform
         System.out.println(">>> MAIN: Creating thread " + i);
         ClientThread t = new ClientThread("No " + i);
         // Pass the work to the pool
         thrPool.submit(t);
         //t.run();
      }

      System.out.println("\n\n\n=================\nMAIN: Main thread completed");
      
   }
   
}

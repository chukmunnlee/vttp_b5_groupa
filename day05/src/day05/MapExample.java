package day05;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

   public static void main(String[] args) {

      byte[] buff;
      List<String> myList;

      Map<String, Integer> myStuff = new HashMap<>();
      Console cons = System.console();

      boolean stop = false;

      while (!stop) {
         String item = cons.readLine("Item: ");
         item = item.trim().toLowerCase();

         if ("stop".equals(item)) {
            stop = true;
            continue;
         }

         int count = 0;
         if (myStuff.containsKey(item))
            count = myStuff.get(item);

         count++;
         myStuff.put(item, count);
      }

      for (String key: myStuff.keySet()) {
         System.out.printf("key: %s, value: %d\n", key, myStuff.get(key));
      }
      
   }
   
}

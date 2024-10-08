package day05;

import java.util.*;
import java.io.*;

public class SaveList {

   public static void main(String[] args) {

      List<String> myList = new LinkedList<>();
      myList.add("apple");
      myList.add("orange");
      myList.add("pear");

      Set<String> mySet = new HashSet<>();
      mySet.add("apple");
      mySet.add("orange");
      mySet.add("pear");

      try {
         writeList2(myList, "abc.txt");
         writeList2(mySet, "abc_set.txt");
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   public static void writeList2(Set<String> set, String fileName) throws IOException {
      Writer writer = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(writer);
      for (String item: set) {
         bw.write(item );
         bw.newLine();
      }

      bw.flush();
      writer.flush();
      bw.close();
      writer.close();
   }

   public static void writeList2(List<String> list, String fileName) 
         throws IOException {
      // Create a file
      Writer writer = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(writer);
      for (String item: list) {
         bw.write(item );
         bw.newLine();
      }

      bw.flush();
      writer.flush();
      bw.close();
      writer.close();
   }
   
}

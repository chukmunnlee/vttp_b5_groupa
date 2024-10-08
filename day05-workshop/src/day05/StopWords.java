package day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class StopWords {

   private Set<String> stopWords = new HashSet<>();

   public void load(String file) throws IOException {
      Reader reader = new FileReader(file);
      BufferedReader br = new BufferedReader(reader);

      String word;
      while ((word = br.readLine()) != null)
         stopWords.add(word.trim().toLowerCase());

      br.close();
      reader.close();
   }

   public boolean isStopWord(String word) {
      return stopWords.contains(word);
   }
   
}

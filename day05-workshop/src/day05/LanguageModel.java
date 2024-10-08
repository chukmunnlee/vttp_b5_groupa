package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LanguageModel {

   private Reader reader;
   private Map<String, Map<String, Integer>> nextWords;
   private Random rand = new SecureRandom();

   public LanguageModel(Reader reader) {
      this.reader = reader;
      this.nextWords = new HashMap<>();
   }

   public void buildModel() throws IOException {

      BufferedReader br = new BufferedReader(reader);
      String line;

      while ((line = br.readLine()) != null) {
         // Clean the line
         line = line.trim().replaceAll("\\p{Punct}", "");
         if (line.length() <= 0)
            continue;
         String[] words = line.split("\\s+");
         for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            addToWordDistribution(curr, next);
         }
      }
   }

   public void dumpModel() {
      for (String curr: nextWords.keySet()) {
         System.out.printf(">> %s\n", curr);
         Map<String, Integer> dist = nextWords.get(curr);
         for (String next: dist.keySet())
            System.out.printf("\t\t%s = %d\n", next, dist.get(next));
      }
   }

   public String generate(String root, int numWords, float hallucination) {
      String theSentence = root;
      String curr = root;
      String next = "";
      float totalRand = 1 - hallucination;
      for (int i = 0; i < numWords; i++) {
         if (rand.nextFloat() > totalRand)
            next = nextWord(curr); // Explotation
         else
            next = randomNext(curr); // Exploration
         if (next.length() <= 0)
            return theSentence;
         theSentence += " " + next;
         curr = next;
      }

      return theSentence;
   }

   public String generate(String root, int numWords) {
      String theSentence = root;
      String curr = root;
      String next = "";
      for (int i = 0; i < numWords; i++) {
         //next = nextWord(curr);
         next = randomNext(curr);
         if (next.length() <= 0)
            return theSentence;
         theSentence += " " + next;
         curr = next;
      }

      return theSentence;
   }

   // Exploration
   public String randomNext(String word) {

      Map<String, Integer> dist = nextWords.get(word);
      if (null == dist)
         return "";

      int numWords = dist.size();
      // Randomly pick a number form the list of next words
      int theWord = rand.nextInt(numWords);
      int i = 0;
      String nw = "";
      for (String w: nextWords.keySet()) {
         nw = w;
         if (i > theWord)
            return w;
         i++;
      }

      return nw;
   }

   // Greedy algo - Exploitation
   public String nextWord(String word) {
      int wordCount = -1;
      String theWord = "";
      Map<String, Integer> dist = nextWords.get(word);
      if (null == dist)
         return "";
      for (String w: dist.keySet())
         if (dist.get(w) > wordCount) {
            wordCount = dist.get(w);
            theWord = w;
         }
      return theWord;
   }

   // Map<String, Map<String, Integer>>
   private void addToWordDistribution(String curr, String next) {

      /*
       * int count = 0;
       * if (map.containsKey('abc'))
       *    count = map.get('abc')
       * count++;
       * map.put('abc', count);
       */

      Map<String, Integer> wordDistrib;
      if (nextWords.containsKey(curr))
         wordDistrib = nextWords.get(curr);
      else
         wordDistrib = new HashMap<>();

      int count = 0;
      if (wordDistrib.containsKey(next))
         count = wordDistrib.get(next);

      count++;
      wordDistrib.put(next, count);

      nextWords.put(curr, wordDistrib);

   }
   
}

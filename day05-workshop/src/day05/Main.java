package day05;

import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

   public static void main(String[] args) throws IOException {
     Reader reader = new FileReader(args[0]) ;
     LanguageModel lm = new LanguageModel(reader);
     lm.buildModel();
     //lm.dumpModel();

     Console cons = System.console();
     while (true) {
      String startWord = cons.readLine("> start word: ");
      int numWords = Integer.parseInt(cons.readLine("> num words: "));
      String generated = lm.generate(startWord, numWords, .75f);

      System.out.printf("\n==============\n%s\n", generated);
     }
   }

}
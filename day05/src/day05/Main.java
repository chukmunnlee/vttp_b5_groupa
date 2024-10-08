package day05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
   public static void main(String[] args) {

      Box<Toy> toyBox = new Box<>();
      Box<Money> moneyBox = new Box<>();

      Box<Box<Money>> safe = new Box<>();

      // String - key, Integer - value
      // Money m = toyBox.getItem();

      Monster m = new Monster();
      Hittable h = m;
      Runnable r = m;
      Hero link = new Hero();
      link.hit(m);

   }
}
package day05;

public class Car {

   // class member
   public final static String VERSION = "v2";

   // instance member
   private String name;

   public String getName() { return name; }
   public void setName(String name) { this.name = name; }

   public static void printCarInfo(Car car) {
      System.out.printf(">> name: %s\n", car.name);

   }


}

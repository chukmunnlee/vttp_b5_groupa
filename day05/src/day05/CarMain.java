package day05;

public class CarMain {

   public static void main(String[] args) {

      Car myCar = new Car();
      myCar.setName("fred");

      Car myOtherCar = new Car();
      myOtherCar.setName("barney");

      System.out.printf(">>> myCar name: %s\n", myCar.getName());
      System.out.printf(">>> myOtherCar name: %d\n", myOtherCar.getName());

      // System.out.printf(">>> myOtherCar version: %s\n", myOtherCar.getVERSION());
      // System.out.printf(">>> myCar version: %d\n", myCar.getVERSION());

      System.out.printf(">>>> version: %s\n", Car.VERSION);
      Car.printCarInfo(myOtherCar);
      
   }
   
}

package day05;

public class Monster implements Hittable, Runnable {

   private int hitPoint;

   public void run() {

   }

   public void damage(int value) {
      hitPoint -= value * .75;
   }

   public int getHitPoint() {
      return hitPoint;
   }

   public void setHitPoint(int hitPoint) {
      this.hitPoint = hitPoint;
   }
   
}

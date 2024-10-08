package day05;

public class Tree implements Hittable {

   private int integrity;

   public void damage(int value) {
      integrity -= value;
   }

   public int getIntegrity() {
      return integrity;
   }

   public void setIntegrity(int integrity) {
      this.integrity = integrity;
   }
   
}

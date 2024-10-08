package day05;

public class Box<T> implements Hittable {

   //private Toy toy;
   private T item;

   private int integrity;

   public void damage(int value) {
      this.integrity -= value;
   }

   public T getItem() { return item; }
   public void setItem(T item) { 
      this.item = item; 
   }
   public int getIntegrity() {
      return integrity;
   }
   public void setIntegrity(int integrity) {
      this.integrity = integrity;
   }
}

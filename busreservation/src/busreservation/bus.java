package busreservation;

public class bus {
  public  int busno,capacity;
  public  boolean ac;
  public bus(int busno,boolean ac,int capacity)
   {
	   this.busno=busno;
	   this.ac=ac;
	   this.capacity=capacity;
   }
   public int getBusno()
   {
	   return busno;
   }
   public int getCapacity()
   {
	   return capacity;
   }
   public void display()
   {
	   System.out.println("busno:"+busno+" ac:"+ac+" capacity:"+capacity);
   }
   
}

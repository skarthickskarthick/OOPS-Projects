package busreservation;

import java.util.*;

public class booking {
  private String name,date;
  private int busno;
  Scanner sc=new Scanner(System.in);
  
  booking()
  {
	  System.out.println("enter the name");
	  name=sc.next();
	  System.out.println("enter the busno");
	  busno=sc.nextInt();
	  System.out.println("enter the date");
	  date=sc.next();
	  }
  public boolean isAvailable( ArrayList<bus> buses, ArrayList<booking> bookings)
  {
	  int capacity=0;
	  for(bus b:buses)
	  {
		  if(b.busno==busno)
			  capacity=b.capacity;
	  }
	  int booked=0;
	  for(booking b:bookings)
	  {
		  if(b.busno==busno&&b.date.equals(date))
			  booked++;  // checks how many passwngers are booked on that date
	  }
	
	  return booked<capacity?true:false;
  }
  public static boolean cancel(String name,int busno, String date,ArrayList<booking> bookings)
  {
	  for(int i=0;i<bookings.size();i++)

  {
		  booking b=bookings.get(i);
		  if(b.name.equals(name)&&b.busno==busno&&b.date.equals(date)) {
			  bookings.remove(i);
			  return true;
		  }
			  
		 
  }
	  return false;
  }
  public void display()
  {
	  System.out.println("name:"+name+" busno:"+busno+" date:"+date);
  }
  
}

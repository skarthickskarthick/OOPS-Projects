package busreservation;

import java.util.*;

public class busmain {
   public static void main(String args[])
   {
	  ArrayList<bus> buses=new ArrayList<bus>();
	  ArrayList<booking> bookings=new ArrayList<booking>();
	  ArrayList<booking> wl=new ArrayList<booking>();
	  buses.add(new bus(1,true,1));
	  buses.add(new bus(2,false,2));
	  
	for(bus b:buses)
	{
		b.display();
	}
	
	
	Scanner sc=new Scanner(System.in);
	int ch=1;

	while(ch!=4)
	{
		System.out.println("1.book 2.cancel 3.display 4.Exit");
		System.out.println("enter the choice");
		ch=sc.nextInt();
		if(ch==1)
		{
			booking b=new booking();
			if(b.isAvailable(buses,bookings))
			{
				bookings.add(b);
				System.out.println("confirmed");
			}
			else {
				System.out.println("added to waiting list");
				wl.add(b);
			}
				
			
		}
		if(ch==2)
		{
			System.out.println("enter the name");
		  String name=sc.next();
			System.out.println("enter the busno");
			int busno=sc.nextInt();
			System.out.println("enter the date");
			String date=sc.next();
			if(booking.cancel(name, busno, date,bookings)) {
			
			System.out.println("cancelled");
			if(!wl.isEmpty()) {
			bookings.add(wl.get(0));
			wl.remove(0);
			}
		}
			else
				System.out.println("not cancelled");
		}
		if(ch==3)
		{
			System.out.println("pasenger list overall");
			for(booking b:bookings)
			{
				b.display();
			}
			System.out.println("waiting list overall");
			for(booking b:wl)
			{
				b.display();
			}
		}
	}
	
	
   }
}

package taxibooking;

import java.util.ArrayList;
import java.util.Scanner;

public class taximain {
  public static void main(String args[])
  {
	  
	  ArrayList<taxi> taxii=new ArrayList<>();
	  taxii.add(new taxi(1,'a',6));
	  taxii.add(new taxi(2,'a',6));
	  taxii.add(new taxi(3,'a',6));
	  taxii.add(new taxi(4,'a',6));
	  
	  ArrayList<passengers> passengerslist=new ArrayList<>();//list of all passengers of all taxis
	  
	  
	  Scanner sc=new Scanner(System.in);
	  int id=1;
	  int option=0;
	  while(option!=4)
	  {
		  System.out.println("1.book 2.passenger display 3.taxi display");
		  System.out.println("enter the option");
		  option=sc.nextInt();
		  
		  if(option==1)
		  {
			  passengers p=new passengers(id++);
			if(p.book(taxii,passengerslist)) {
				passengerslist.add(p);
				taxii.get(p.taxino-1).passengerlist.add(p);//adding passenger to the respective taxi no
				
			}
				  
		  }
		  if(option==2)
		  {
			  for(passengers p1:passengerslist)
			  {
				  p1.display();
			  }
		  }
		  if(option==3)
		  {
			  for(taxi t1:taxii)
			  {
				  t1.display();
			  }
		  }
	  }
  }
}

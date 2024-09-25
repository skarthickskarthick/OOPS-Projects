package railwayreservation;

import java.util.ArrayList;
import java.util.*;

public class railmain {
 public static void main(String args[])
 {
	 ArrayList<trainmodel> train=new ArrayList<>(); //creating trains with no and berthcapacity
	 HashMap<Character,Integer> berth=new HashMap<>();
	 berth.put('u', 1);
	 berth.put('m', 1);
	 berth.put('l', 1);
	 
	 train.add(new trainmodel(1,berth));
	 train.add(new trainmodel(2,berth));
	 int option=0;
	 Scanner sc=new Scanner(System.in);
	 ArrayList<reservation> passenger=new ArrayList<>();// this is a general list of passengers for all the trains mixed together
	 while(option!=4) {
		 System.out.println("1.book 2.cancel 3.display 4.exit");
		 System.out.println("enter the option");
		 option=sc.nextInt();
		 if(option==1)
		 {
			 reservation r=new reservation();
			 if(r.isAvailable(train,passenger)) {
				 r.tickettype="confirm";
				 passenger.add(r);
				 System.out.println("booking confirmed");
			 }
			
			 else
				passenger= r.otherbooking(train,passenger,r);
				 
			 
			 
		 }
		 if(option==2)
		 {
			 reservation r=new reservation();
			passenger= r.cancel(passenger,train);
		 }
		 if(option==3)//display all passenger list 
		 {
			 for(reservation p:passenger)
				p.display();
		 }
	 }
	 
	 
 }
}

package taxibooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class passengers {
   int id;
  int pickuptime;
  char pickuppoint;
  char droppoint;
  int taxino;
  
  Scanner sc=new Scanner(System.in);
  public passengers(int id)
  {
	  this.id=id;
	  System.out.println("enter the pickuptime");
	  pickuptime=sc.nextInt();
	  System.out.println("enter the pickuppoint");
	  pickuppoint=sc.next().charAt(0);
	  System.out.println("enter the droppoint");
	  droppoint=sc.next().charAt(0);
  }
  
  public boolean book(ArrayList<taxi> taxii,ArrayList<passengers> p)
  {
	  ArrayList<taxi> freetaxi=new ArrayList<>();
			  freetaxi=getfreetaxi(taxii,pickuptime,pickuppoint);
	  if(freetaxi.isEmpty())
	  {
		  System.out.println("not booked");
		  return  false;
	  }
	  Collections.sort(freetaxi,(a,b)->a.earnings-b.earnings);//sort the list based on the earnings
	  //If the result is negative, a comes before b.
	  //If the result is positive, b comes before a.
	  //If the result is zero, their order is unchanged.
	  int min=1000,distance=0;
	  taxi allotedtaxi=null;
	 // System.out.println(freetaxi);
	  for(taxi t:freetaxi)
	  {
		   distance=Math.abs((t.currentlocation-'0')-(pickuppoint-'0'))*15;//distance between the station is 15km
		  if(distance<min)
		  {
			  allotedtaxi=t;
			  min=distance;
			  
		  }
	  }
	  allotedtaxi.currentlocation=droppoint;
	  allotedtaxi.freetime=pickuptime+Math.abs((pickuppoint-'0')-(droppoint-'0'));
	  allotedtaxi.earnings=100+(distance-5)*10;
	 // id=++id;
	  taxino=allotedtaxi.no;
	  return true;
	  
	  
  }
  public ArrayList<taxi> getfreetaxi(ArrayList<taxi> taxii,int pickuptime,char pickuppoint)
  {
	  ArrayList<taxi> freetaxi=new ArrayList<>();
	  for(taxi t:taxii)
	  {
		  if(t.freetime<=pickuptime&&Math.abs((t.currentlocation-'0')-(pickuppoint-'0'))<=pickuptime-t.freetime)
		  {                          //traveeling time from currentlocation to pickuppoint should not exceed the pickuptime
			 freetaxi.add(t);
		  }
	  }
	  return freetaxi;
  }
  public void display()
  {
	  System.out.println("id: "+id+" pickuptime: "+pickuptime+"  pickuppoint: "+pickuppoint+" droppoint: "+droppoint+" taxino: "+taxino);
  }
}

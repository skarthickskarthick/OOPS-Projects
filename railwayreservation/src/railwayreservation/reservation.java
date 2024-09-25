package railwayreservation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class reservation {
	Scanner sc=new Scanner(System.in);
	int no;
	String name;
	String date;
	char berth;
	String tickettype;// to sort the tickets based on the type -confirm,rac,wl during cancel operations
	
reservation()//this is called immediately after the object for this class is created
{
	System.out.println("enter the train no");
	 no=sc.nextInt();
	System.out.println("enter the passenger name");
	name=sc.next();
	System.out.println("enter the date");
	date=sc.next();
	System.out.println("enter the berth");
	berth=sc.next().charAt(0);
	
}

char allotedberth;
public boolean isAvailable(ArrayList<trainmodel> trains,ArrayList<reservation> passenger)
{
	trainmodel requiredtrain=null;   // to check the given berth is available
	int bookedpassengers=0;
	for(trainmodel train:trains)
	{
		if(train.no==no)
		{
			requiredtrain=train;
		}
	}
	int berthcapacity=requiredtrain.berthcapacity.get(berth);
	for(reservation p:passenger)
	{
		if(p.date.equals(date)&&p.allotedberth==berth&&p.no==no)
		{
		bookedpassengers++;	
		}
	}
	allotedberth=berth;
	return bookedpassengers<berthcapacity?true:false;
	
	
	
}


public boolean isAvailableberths(ArrayList<trainmodel> trains,ArrayList<reservation> passenger,char berthh,String datee)
{
	trainmodel requiredtrain=null;  // to check whether the other berth are available
	int bookedpassengers=0;
	for(trainmodel train:trains)
	{
		if(train.no==no)
		{
			requiredtrain=train;
		}
	}
	int berthcapacity=requiredtrain.berthcapacity.get(berthh);
	for(reservation p:passenger)
	{
		if(p.date.equals(datee)&&p.allotedberth==berthh&&p.no==no)//consider date,berth and train no.
		{
		bookedpassengers++;	
		}
		
	}
	//System.out.println(berthcapacity+" "+bookedpassengers);
	allotedberth=berthh;
	return bookedpassengers<berthcapacity?true:false;
	
	
	
}


public ArrayList<reservation> otherbooking(ArrayList<trainmodel> trains,ArrayList<reservation> passenger,reservation r)
{
	trainmodel requiredtrain=null;
	for(trainmodel t:trains)
	{
		if(t.no==no)
			requiredtrain=t;
	}	
	if(isAvailableberths(trains,passenger,'u',r.date))
	{
		r.tickettype="confirm";
		passenger.add(r);
		System.out.println("alloted for berth u");
		
	}
	else if(isAvailableberths(trains,passenger,'m',r.date))
	{
		r.tickettype="confirm";
		passenger.add(r);
		System.out.println("alloted for berth m");
	
	}
	else if(isAvailableberths(trains,passenger,'l',r.date))
	{
		r.tickettype="confirm";
		passenger.add(r);
		System.out.println("alloted for berth l");
	}
	
	else if(requiredtrain.rac.size()<1){  //add to rac
		r.tickettype="rac";
		allotedberth='r';
		passenger.add(r);
		requiredtrain.rac.add(r);
	//System.out.println(rac.size());
		System.out.println("alloted for rac");
		
	}
	else if(requiredtrain.wl.size()<1)//add to wl
	{
		r.tickettype="wl";
		allotedberth='w';
		passenger.add(r);
		requiredtrain.wl.add(r);
		System.out.println("alloted for waiting list");
	}
	else {
		System.out.println("not booked");
		
	}
		
		
	return passenger;
}
public trainmodel gettrain(ArrayList<trainmodel> trains)
{
	trainmodel requiredtrain=null;
	for(trainmodel t:trains)// get the train with the no.
	{
		if(t.no==no)
			requiredtrain=t;
	}
	return requiredtrain;
	
}
public reservation getpassenger(ArrayList<reservation> passenger)
{
	reservation cancelpassenger=null;
	 for(reservation r:passenger)//get the input passenger from the passenger list
	    {
	    	if(r.no==no&&r.name.equals(name)&&r.date.equals(date))
	    	{
	    	      
	    	      	cancelpassenger=r;
	    	}
	    }
	 return cancelpassenger;
}
public ArrayList<reservation> cancel(ArrayList<reservation> passenger,ArrayList<trainmodel> trains)
{
	
	trainmodel requiredtrain=gettrain(trains);
	
	
	reservation firstrac=null;
	
	for(reservation r:requiredtrain.rac) //get the first element of the raclist of the required train number
	{                                    //based on the given date
		if(r.date.equals(date));
		{
			firstrac=r;
			break;
		}
	}
	
	reservation cancelpassenger=getpassenger(passenger);;
    //System.out.println(firstrac.name);

    
    if(cancelpassenger==null) {
    	System.out.println("invalid cancellation");
    return passenger;}
    reservation firstwl=null;
    for(reservation r:requiredtrain.wl)   //get the first wl elenent for the given date of the required train number
	{
		if(r.date.equals(date));
		{
			firstwl=r;
			break;
		}
	}
    if(cancelpassenger.tickettype.equals("confirm"))
    {
    	if(firstrac!=null)
    	{
    	 firstrac.allotedberth=cancelpassenger.allotedberth;
    	    firstrac.tickettype=cancelpassenger.tickettype;
    	   // passenger.add(firstrac);
    	    requiredtrain.rac.remove(firstrac);
    	}
    	    
    	    if(firstwl!=null)
    	    {
    	    
    	    firstwl.allotedberth='r';
    	    firstwl.tickettype="rac";
    	    requiredtrain.rac.add(firstwl);
    	    requiredtrain.wl.remove(firstwl);
    	    }
    	    passenger.remove(cancelpassenger);
    }
    else if(cancelpassenger.tickettype.equals("rac"))
    {
    	
    	requiredtrain.rac.remove(cancelpassenger);
    	if(firstwl!=null)
    	{
    	firstwl.allotedberth='r';
	    firstwl.tickettype="rac";
	    requiredtrain.rac.add(firstwl);
	    requiredtrain.wl.remove(firstwl);
    	}
	    passenger.remove(cancelpassenger);
    }
    else
    {
    	passenger.remove(cancelpassenger);
    	requiredtrain.wl.remove(cancelpassenger);
    }
   
    
    



	return passenger;
}
public void display()
{
	
	System.out.println("name: "+name+"  berth: "+berth+"  allotedberth:  "+allotedberth+"  trainno.: "+no+"  date: "+date);
}
}

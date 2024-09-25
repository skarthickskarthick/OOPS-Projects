package taxibooking;

import java.util.ArrayList;

public class taxi {
       int no;
       char currentlocation;
       int earnings=0;
       int freetime;
       ArrayList<passengers> passengerlist=new ArrayList<>();
       public taxi(int no,char currentlocation,int freetime)
       {
    	   this.no=no;
    	   this.currentlocation=currentlocation;
    	   this.freetime=freetime;
       }
       public void display()
       {
    	   System.out.println("taxi"+no);
    	   System.out.println("current location:"+currentlocation+" earnings: "+earnings+"  freetime: "+freetime);
    	   for(passengers p:passengerlist)
    	   {
    		   p.display();
    	   }
    	   
       }
      
}

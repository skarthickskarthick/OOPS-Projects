package equations;

import java.util.ArrayList;
import java.util.Scanner;

public class equationmain {
  public static void main(String args[])
  {
	  
	  ArrayList<variables> variable1=new ArrayList<>();
	  variable1.add(new variables("x",2));
	  variable1.add(new variables("y",1));
	  //variable1.add(new variables("x",0));
	  ArrayList<variables> variable2=new ArrayList<>();
	  variable2.add(new variables("x",2));
	  variable2.add(new variables("z",1));
	 // variable2.add(new variables("y",0));
	  ArrayList<variables> variable3=new ArrayList<>();
	  variable3.add(new variables("k",2));
	  variable3.add(new variables("n",1));
	  
	  ArrayList<terms> term1=new ArrayList<>();
	  term1.add(new terms(2,variable1));
	  term1.add(new terms(1,variable2));
	 // term1.add(new terms(3,variable3));
	  ArrayList<terms> term2=new ArrayList<>();
	  term2.add(new terms(1,variable1));
	  term2.add(new terms(-2,variable2));
	  term2.add(new terms(-2,variable3));
	  
	  
	  ArrayList<equations> eqn=new ArrayList<>();
	  eqn.add(new equations(1,term1));
	  eqn.add(new equations(2,term2));
	  
	  
	  Scanner sc=new Scanner(System.in);
	  
	  int option=0;
	  while(option!=4)
	  {
		  System.out.println("1.display 2.add 3.multilply 4.exit");
		  System.out.println("enter the option");
		  option=sc.nextInt();
		  if(option==1)
		  {
			  for(equations e:eqn)
			  {
				  e.display();
			  }
		  }
		  if(option==2)
		  {
			 eqn= operations.add(eqn);
			 for(equations e:eqn)
			  {
				  e.display();
			  }
		  }
		  if(option==3)
		  {
			  eqn= operations.multiply(eqn);
				 for(equations e:eqn)
				  {
					  e.display();
				  }
		  }
	  }
  }
}

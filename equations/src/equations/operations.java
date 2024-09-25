package equations;

import java.util.ArrayList;

public class operations {
	//static int n=3;
	
	
public static ArrayList<equations> add(ArrayList<equations> eqn)
{
	equations eqn1=eqn.get(0);//only 2 equations
	equations eqn2=eqn.get(1);
	equations ans=new equations();
	ans.no=3;
	
	  
	
	// add the matching variables coeff and also add the unmatched terms of the 1st eqn.
	for(int i=0;i<2;i++)//no. of terms in 1st eqn
	{
		terms t1=eqn1.term.get(i);
		int flag=0,coeff=0;
		boolean matched=false;
		for(int j=0;j<3;j++)  //no. of terms in 2nd eqn
		{
			terms t2=eqn2.term.get(j);
			ArrayList<variables> ansvariable=new ArrayList<>();
			coeff=t1.coeffient+t2.coeffient;
			
			flag=0;
			for(int k=0;k<t2.variable.size()&&k<t1.variable.size();k++) {
				
				
			if(t1.variable.get(k).var.equals(t2.variable.get(k).var)&&t1.variable.get(k).degree==t2.variable.get(k).degree)
			{
				
				ansvariable.add(new variables(t1.variable.get(k).var,t1.variable.get(k).degree));
				
				
				flag++;
			}	
			}
			
			if(flag==t1.variable.size())
			{
				ans.term.add(new terms(coeff,ansvariable));
			   matched=true;
				break;
			}
		//	ansvariable.removeFirst();
			
		}
		
		if(!matched)
		{
			ans.term.add(t1);
	
		
		}
		
	}
	
	//to check for 2nd eqn if extra term is there and add it to ans eqn
	
	for(int i=0;i<3;i++)
	{
		terms t1=eqn2.term.get(i);
	int flag=0;
	boolean matched=false;
		for(int j=0;j<2;j++)
		{
			terms t2=eqn1.term.get(j);
			flag=0;
			for(int k=0;k<t2.variable.size()&&k<t1.variable.size();k++) {
				if(t1.variable.get(k).var.equals(t2.variable.get(k).var)&&t1.variable.get(k).degree==t2.variable.get(k).degree)
			{
				flag++;
				
				
			}
			}
			if(flag==t1.variable.size())
			{
				matched=true;
			
				break;
			}
			
		}
		if(!matched)
		{
			ans.term.add(t1);
		}
	}
	
	eqn.add(ans);
	return eqn;
}





public static ArrayList<equations> multiply(ArrayList<equations> eqn)
{
	equations eqn1=eqn.get(0);//only 2 equations
	equations eqn2=eqn.get(1);
	equations ans=new equations();
	ans.no=4;
	
	  
	
	// multiply the  coeff and also inlcude the unmatched and matched terms of the 1st eqn.
	for(int i=0;i<2;i++)//no. of terms in 1st eqn
	{
		terms t1=eqn1.term.get(i);
		int flag=0,coeff=0;
		boolean matched=false;
		for(int j=0;j<3;j++)  //no. of terms in 2nd eqn
		{
			terms t2=eqn2.term.get(j);
			ArrayList<variables> ansvariable=new ArrayList<>();
			ArrayList<variables> ansvariable1=new ArrayList<>();
			coeff=t1.coeffient*t2.coeffient;
			
			flag=0;
			for(int k=0;k<t2.variable.size()&&k<t1.variable.size();k++) {
				
				
			if(t1.variable.get(k).var.equals(t2.variable.get(k).var)&&t1.variable.get(k).degree==t2.variable.get(k).degree)
			{
				
				ansvariable.add(new variables(t1.variable.get(k).var,t1.variable.get(k).degree*2));
				ansvariable1.add(new variables(t1.variable.get(k).var,t1.variable.get(k).degree*2)); //for matching tems ansvariable is used
				
				
				flag++;
			}	
			else
			{
				ansvariable1.add(new variables(t1.variable.get(k).var,t1.variable.get(k).degree));
				ansvariable1.add(new variables(t2.variable.get(k).var,t2.variable.get(k).degree));// for unmatched terms ansvariable1 is used 
			}
			}
			
			if(flag==t1.variable.size())
			{
				ans.term.add(new terms(coeff,ansvariable));
			   matched=true;
			
			}
			else
				ans.term.add(new terms(coeff,ansvariable1));			
		}
	}
	eqn.add(ans);
	return eqn;
}
}

package equations;

import java.util.ArrayList;

public class terms {
 int coeffient;
 ArrayList<variables> variable;
 terms(int coefficient,ArrayList<variables> variable)
 {
	 this.coeffient=coefficient;
	 this.variable=variable;
 }
 public void display()
 {
	 if(coeffient<0)
	 {
		 System.out.print("  "+coeffient);
		 for(variables v:variable)
		 {
			 System.out.print(""+v.var+"^"+v.degree);
		 }
	 }
	 
	 else
	 {
		 System.out.print("  +"+coeffient);
		 for(variables v:variable)
		 {
			 System.out.print(""+v.var+"^"+v.degree);
		 }
	 }
	 
 }
}

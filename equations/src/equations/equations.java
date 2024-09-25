package equations;

import java.util.ArrayList;

public class equations {
	int no;
ArrayList<terms> term=new ArrayList<terms>();


public equations(int no,ArrayList<terms> term)
{
	this.no=no;
	this.term=term;
}
equations()
{
	
}
public void display()
{
	System.out.println("no: "+no+"  ");
	for(terms t:term)
	{
		t.display();
	}
	System.out.println();
}
}

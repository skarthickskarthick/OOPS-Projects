package bala;

import java.util.ArrayList;

public class balamain {
	public static  void addsiblings(ArrayList<model> m)
	{
		for(int i=0;i<m.size();i++)//adding siblings
		{
			model fat=m.get(i).father;
			for(int j=i+1;j<m.size();j++)
			{
				if(fat!=null&&m.get(j).father!=null&&m.get(j).father.equals(fat))
				{
					m.get(i).siblings.add(m.get(j));
					m.get(j).siblings.add(m.get(i));
				}
			}
		}
	}
	public static void getcousin(String namee,ArrayList<model> m)
	{
		for(model m1: m)//accessing the siblings
		{
			if(m1.name==namee)
			{
				System.out.println("mother side cousins");
			 ArrayList<model> brother=  getbrother(m1.mother);
			
			 if(m1.gender=="f") {
			for(model bro:brother)
			{
				System.out.println(getson(m,bro).toString());
			}
			 
			 }
			 else
			 {
				 for(model bro:brother)
					{
					 System.out.println(getdaughter(m,bro).toString());
					}
			 }
			 System.out.println("father side cousins");
			 ArrayList<model> sister=  getsister(m1.father);
			 if(m1.gender=="f") {
			for(model sis:sister)
			{
				System.out.println(getson(m,sis).toString());
			}
			
			 }
			 else
			 {
				 for(model sis:sister)
					{
						System.out.println(getdaughter(m,sis).toString());
					}
			 }
				 
			}
		}
		
	}
	public static ArrayList<model> getbrother(model m)
	{
		ArrayList<model> brother=new ArrayList<>();
		ArrayList<model> sib=m.siblings;
		for(model m2:sib)
		{
			if(m2.gender.equals("m")) {
				brother.add(m2);
			//System.out.println(m2.name);
			}
		}
		return brother;
	}
	public static ArrayList<model> getsister(model m)
	{
		ArrayList<model> sister=new ArrayList<>();
		ArrayList<model> sib=m.siblings;
		for(model m2:sib)
		{
			if(m2.gender.equals("f")) {
				sister.add(m2);
			//System.out.println(m2.name);
			}
		}
		return sister;
	}
	public static ArrayList<model> getson(ArrayList<model> m,model mod)
	{
		ArrayList<model> sons=new ArrayList<>();
		
		   for(model m3:m)
		{
			if(m3.father!=null&&m3.father.name.equals(mod.name)&&m3.gender=="m")
			{
			 sons.add(m3);
			}
		}
		   return sons;
		
	}
	
	public static ArrayList<model> getdaughter(ArrayList<model> m,model mod)
	{
		ArrayList<model> daughter=new ArrayList<>();
		
		   for(model m3:m)
		{
			if(m3.father!=null&&m3.father.name.equals(mod.name)&&m3.gender=="f")
			{
			 daughter.add(m3);
			}
		}
		   return daughter;
		
	}
	
	
public static void main(String[] args)
{

	
	ArrayList<model> m=new ArrayList<>();
	m.add(new model("eswaran",null,null,"m"));//0
	
	m.add(new model("kannan",m.get(0),null,"m"));//1
	m.add(new model("bala",m.get(1),null,"m"));//2
	
	
	System.out.println(m.get(2).father.father.name);//grandfather access
	
m.add(new model("vicky",m.get(1),null,"f"));//3
m.add(new model("vickymalechild",null,m.get(3),"m"));//4
m.add(new model("balamalechild",m.get(2),null,"m"));//5
m.add(new model("balafemalechild",m.get(2),null,"f"));//6
m.add(new model("balabrother",m.get(1),null,"m"));//7
m.add(new model("godfather",null,null,"m"));//8
m.add(new model("vickyhusband",m.get(8),null,"m"));//9
m.add(new model("vickyhusband sister",m.get(8),null,"f"));//10
m.add(new model("vickyhusband sister son",m.get(10),m.get(10),"m"));//11
m.add(new model("vickyfemalechild",m.get(9),m.get(3),"f"));//12


	addsiblings(m);
	//System.out.println(getson(m,m.get(10)).toString());
	//System.out.println(m.get(7).siblings.get(0).father.name);
	getcousin("vickyfemalechild",m);
}
}

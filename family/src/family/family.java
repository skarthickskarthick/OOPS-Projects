package family;

import java.util.ArrayList;

public class family {
   String name;
   family father;
   family mother;
   ArrayList<family> dau=new ArrayList<>();
   ArrayList<family> sis=new ArrayList<>();
   ArrayList<family> bro=new ArrayList<>();
   ArrayList<family> son=new ArrayList<>();
  String gender;
   family(String name,family father,family mother,String gender)
   {
	   this.name=name;
	   this.father=father;
	   this.mother=mother;
	   this.gender=gender;
	   }
   public void setFather(family father)
   {
	   this.father=father;
   }
   public void setSister(family s)
   {
	   sis.add(s);
	  
   }
   public void setDaughter(family d)
   {
	   dau.add(d);
	  
   }
   public void setMother(family mother)
   {
	   this.mother=mother;
   }
   public void setBrother(family b)
   {
	   bro.add(b);
	  
   }
   public void setSon(family so)
   {
	   son.add(so);
	  
   }
   @Override
   public String toString() {
       return this.name;
   }
   
}

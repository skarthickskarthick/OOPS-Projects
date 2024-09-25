package family;

import java.util.ArrayList;

public class familymain {
    public static void main(String args[])
    {
    	// convet the persons as arraylist with type family
    	
    	
    	
    	
      	family rajammal=new family("rajammal",null,null,"f");
    	family essaki=new family("essaki",null,null,"m");
    	
    	family sudalai=new family("sudalai muthu",essaki,null,"m");
    	family karthick=new family("karthick",sudalai,rajammal,"m");
    	System.out.println(karthick.father.father.name);
    	
    	
    	family a=new family("a",essaki,null,"f");
    	
    	 
    	 sudalai.setSister(a);
    	 
    	 sudalai.setSister(a);//convert this to dynamic forms
    	 
    	 family x=new family("x",null,null,"f");
    	 family y=new family("y",null,null,"m");
    	 a.setDaughter(x);
    	 a.setSon(y);
    	 
    	 
    	 
    
     	System.out.println(karthick.father.sis.get(0).dau.toString());
     	System.out.println(karthick.father.sis.get(0).son.toString());
     	
     	
   
     	family sailu=new family("sailu",null,null,"m");
     	family xx=new family("xx",null,null,"f");
     	karthick.setMother(rajammal);
     	rajammal.setBrother(sailu);
     	sailu.setDaughter(xx);
     	System.out.println(karthick.mother.bro.get(0).dau.toString());
    	
    }
    	
}

package bankapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class transaction {
     int tid;
    String type;
     double amount;
   customer c;
    Scanner sc=new Scanner(System.in);
   transaction(int tid)
   {
       c=new customer();
       this.tid=tid;
       System.out.println("enter the ac no");
       c.acno = sc.nextInt();
       System.out.println("enter the name");
       c.name =sc.next();
       System.out.println("enter the amount");
       this.amount= sc.nextDouble();
       System.out.println("enter the password");
        c.password= sc.next();


   }


    public boolean add(ArrayList<transaction> transactions,int noc)
    {
        Scanner sc=new Scanner(System.in);

        c.id=++noc;
        System.out.println("reenter the password");
        String repassword= sc.nextLine();
        if(!c.password.equals(repassword))
        {
            System.out.println("not created");
            return false;
        }
        c.password=encryptpassword(repassword);
        type="new";
        c.balance=amount;
        return true;


    }
  public String encryptpassword(String str)
  {
      String password="";
      for(char c:str.toCharArray())
      {
          password+=String.valueOf((char)(c+1));
      }
      return password;
  }
    public String toString()
    {
        return tid+" "+type+" "+amount+" "+c.toString();
    }
}

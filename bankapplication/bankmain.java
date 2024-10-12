package bankapplication;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class bankmain {
    public static void main(String args[]) throws IOException
    {
        ArrayList<customer> customers=new ArrayList<>();
        customers=readfile();

       System.out.println(customers.toString());

        ArrayList<transaction> transactions=new ArrayList<>();

        Scanner sc=new Scanner(System.in);
        int ch=0,tid=1;
        while(ch!=2)
        {
            System.out.println("1.add customer 2.exit");
            System.out.println("enter the choice");
            ch=sc.nextInt();
            if(ch==1)
            {
                transaction t=new transaction(tid++);
               if(t.add(transactions,noofcustomers()))
               {
                   transactions.add(t);
                   customers.add(t.c);
                   writetofile(t.c);
               }

                System.out.println(transactions.toString());
                System.out.println(customers.toString());

            }
        }










    }
    public static ArrayList<customer> readfile() throws IOException
    {
        ArrayList<customer> customers=new ArrayList<>();
        String filename= "bankdb.txt";
        File f=new File(filename);
        BufferedReader br=new BufferedReader(new FileReader(f));
        String c=br.readLine();
        do{

            customers.add(splitcustomer(c));
            c=br.readLine();
        }while(c!=null);
        return customers;
    }
    public static customer splitcustomer(String c)
    {
        String[] str=c.split(" ");
        customer cus=new customer();
        cus.id=Integer.parseInt(str[0]);
        cus.acno=Integer.parseInt(str[1]);
        cus.name=str[2];
        cus.balance=Double.parseDouble(str[3]);
        cus.password=str[4];
        return cus;
    }
    public static int noofcustomers() throws IOException
    {
       int noc=0;
        String filename= "bankdb.txt";
        File f=new File(filename);
        BufferedReader br=new BufferedReader(new FileReader(f));
        String c=br.readLine();
        do{

            noc++;
            c=br.readLine();
        }while(c!=null);
        br.close();
        return noc;
    }
    public static  void writetofile(customer c) throws IOException
    {
        String filename="bankdb.txt";
       File f=new File(filename);
        BufferedWriter br=new BufferedWriter(new FileWriter(f,true));
        br.newLine();
        br.write(c.toString());
        br.close();

    }
}

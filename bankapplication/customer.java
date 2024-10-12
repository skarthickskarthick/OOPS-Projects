package bankapplication;

public class customer {
    int id;
    int acno;
    String name;
    double balance;
    String password;
    customer(int id,int acno,String name,double balance,String pasword)
    {
        this.id=id;
        this.acno=acno;
        this.name=name;
        this.balance=balance;
        this.password=password;
    }
    customer()
    {

    }
    @Override
    public String toString()
    {
        return id+" "+acno+" "+name+" "+balance+" "+password;
    }
}

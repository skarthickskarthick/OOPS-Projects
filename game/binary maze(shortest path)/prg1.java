package zohodrive;
import java.util.*;
public class prg1 {
    public static void main(String[] args) {
        int mat[][]=new int[8][8];
        int tari=7,tarj=7;

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat.length;j++)
            {
                mat[i][j]=100;
            }
        }
       ArrayList<Integer> l=new ArrayList<>();
        l.add(0);
        l.add(0);
        l.add(0);
        ArrayList<ArrayList<Integer>>  index=new ArrayList<>();
        index.add(new ArrayList<>(l));
       int d=1;
        while(index.size()!=0)
        {
            System.out.println(index);
            int i=index.get(0).get(1);
            int j=index.get(0).get(2);
            if(possible(i-1,j,mat))
            {

                if(i-1==tari&&j==tarj)
                {
                    System.out.print(index.get(0).get(0)+1);
                    break;
                }
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(index.get(0).get(0)+1);
                temp.add(i-1);
                temp.add(j);
                index.add(new ArrayList<>(temp));
            }
            if(possible(i+1,j,mat))
            {

                if(i+1==tari&&j==tarj)
                {
                    System.out.print(index.get(0).get(0)+1);
                    break;
                }
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(index.get(0).get(0)+1);
                temp.add(i+1);
                temp.add(j);
                index.add(new ArrayList<>(temp));
            }
            if(possible(i,j-1,mat))
            {

                if(i==tari&&j-1==tarj)
                {
                    System.out.print(index.get(0).get(0)+1);
                    break;
                }
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(index.get(0).get(0)+1);
                temp.add(i);
                temp.add(j-1);
                index.add(new ArrayList<>(temp));
            }
            if(possible(i,j+1,mat))
            {

                if(i==tari&&j+1==tarj)
                {
                    System.out.print(index.get(0).get(0)+1);
                    break;
                }
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(index.get(0).get(0)+1);
                temp.add(i);
                temp.add(j+1);
                index.add(new ArrayList<>(temp));
            }

            ++d;

            index.remove(0);
        }



    }
    public static boolean possible(int i,int j,int[][]mat)
    {
        if(i>=0&&i<8&&j>=0&&j<8&&mat[i][j]==100)
        {

         mat[i][j]=1;
            return true;
        }

        return false;
    }
}

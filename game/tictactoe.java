package game;

import java.util.ArrayList;
import java.util.Scanner;

public class tictactoe {
	public static void print(char mat[][])
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
			System.out.println();
		}
	}
	public static char[][] insert(char[][] mat,int i,int j,boolean xoflag)
	{
		if(mat[i][j]!='x'&&mat[i][j]!='o') {
			
		
		if(xoflag)
			mat[i][j]='x';
		else
			mat[i][j]='o';
		}
		else
			System.out.println("invalid move");
		return mat;
	}
	public static boolean check(char[][]mat,boolean xoflag)
	{
		char target;
		boolean ans;
		if(xoflag)
			target='o';
		else
			target='x';
		for(int i=0;i<mat.length;i++)
		{
			ans=checkrow(mat[i],target);
			if(ans)
				return false;
		}
		 char temp[]=new char[mat.length];
		 int in=0;
		 for(int i=0;i<mat.length;i++)
		 {
			 temp[in++]=mat[i][i];
		 }
		 
		 ans=checkrow(temp,target);
			if(ans)
				return false;
		 char temp1[]=new char[mat.length];
		 int in1=0;
		 for(int i=0;i<mat.length;i++)
		 {
			 temp1[in1++]=mat[i][mat.length-i-1];
		 }
		 
		 ans=checkrow(temp1,target);
			if(ans)
				return false;
		
			ArrayList<Character> l=new ArrayList<>();
			for(int i=0;i<mat.length;i++)
			{
				for(int j=0;j<mat[0].length;j++)
				{
					l.add(mat[j][i]);
				}
				 ans=checkrowlist(l,target);
					if(ans)
						return false;
					l.clear();
			}
			
		
		return true;
	}
	public static boolean checkrow(char[] arr,char target)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=target)
				return false;
		}
		return true;
	}
	public static boolean checkrowlist(ArrayList<Character> arr,char target)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i)!=target)
				return false;
		}
		return true;
	}
	public static boolean matrixfull(char[][] mat)
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				if(mat[i][j]=='0')
					return false;
			}
		}
		return true;
	}
	public static void main(String args[])
	{
		
		char mat[][]=new char[3][3];
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				mat[i][j]='0';
			}
		}
		 print(mat);
		boolean flag=true,xoflag=true;
		Scanner sc=new Scanner(System.in);
		
		int i,j;
		while(flag) 
		{
			System.out.println("enter the row and column index");
			i=sc.nextInt();
			j=sc.nextInt();
		  if(xoflag) {
			mat=insert(mat,i,j,true);
			xoflag=false;
		  }
		  else {
			 mat= insert(mat,i,j,false);
			  xoflag=true;
		  }
		  flag=check(mat,xoflag);
		  
		  print(mat);
		  if(!flag&&xoflag)
			  System.out.println("o wins");
		  else if(!flag&&!xoflag)
			  System.out.println("x wins");
		  if(matrixfull(mat))
			  break;
		}
		System.out.println("game over");
		
	}

}

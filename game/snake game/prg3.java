package zohodrive;

import java.util.*;

public class prg3 {
  static  char[][] board=new char[6][6];
   static Queue<node> que=new LinkedList<>();


    public static void main(String args[])
    {

        for(int i=0;i< board.length;i++)
        {
            for(int j=0;j< board.length;j++)
            {
                board[i][j]='0';
            }
        }
        board[1][0]='X';
        board[2][2]='X';
        board[3][4]='X';
        board[5][2]='X';
        que.add(new node(0,0));
        solve(0,0);

    }
    public static  void solve(int i, int j)
    {
        Scanner sc=new Scanner(System.in);


        if(i>=0&&i<board.length&&j>=0&&j< board.length) {
            if(board[i][j]=='.')
            {
                System.out.println("game over");
                System.exit(0);
            }
            que.add(new node(i,j));

            if(board[i][j]!='X')
            {
               node n=que.poll();
               board[n.getRow()][n.getCol()]='0';

            }

            board[i][j]='.';

            while (!que.isEmpty()) {
                print();

                System.out.println("enter the direction");
                char ch = sc.next().charAt(0);
                if (ch == 'u') {
                    solve(i - 1, j);
                }
                if (ch == 'd') {
                    solve(i + 1, j);
                }
                if (ch == 'l') {
                    solve(i, j - 1);
                }
                if (ch == 'r') {
                    solve(i, j + 1);
                }
            }
        }
        else
        {
            System.out.println("invalid move");
            System.exit(0);
        }

    }
    public static void print()
    {
        for(int i=0;i< board.length;i++)
        {
            for(int j=0;j< board.length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    }


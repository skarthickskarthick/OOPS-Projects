package zohodrive;


    class suduko {
        public static void main(String args[]) {
            int[][] board = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                    { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                    { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

            if (solve(board))
                display(board);
            else
                System.out.println("can't solve");
        }

        static boolean solve(int[][] board) {
            int n = board.length;
            int r = -1, c = -1;
            boolean emptyleft = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        r = i;
                        c = j;
                        emptyleft = false;
                        break;
                    }
                }
                if (emptyleft == false)
                    break;
            }
            if (emptyleft == true)
                return true;
            for (int i = 1; i <= 9; i++) {
                if (issafe(board, r, c, i)) {
                    board[r][c] = i;
                    if (solve(board)) {

                        return true;
                    } else
                        board[r][c] = 0;
                }
            }
            return false;
        }

        static void display(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        static boolean issafe(int[][] board, int r, int c, int n) {
            //check row
            for (int i = 0; i < board.length; i++) {
                if (board[r][i] == n) return false;
            }
            // Check column
            for (int i = 0; i < board.length; i++) {
                if (board[i][c] == n) return false;
            }
            //check the subgrid
            int sqrt = (int) (Math.sqrt(board.length));
            int rs = r - r % sqrt;
            int cs = c - c % sqrt;
            for (int i = rs; i < rs + sqrt; i++) {
                for (int j = cs; j < cs + sqrt; j++) {
                    if (board[i][j] == n)
                        return false;
                }
            }
            return true;
        }
    }


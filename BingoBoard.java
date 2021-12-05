import java.util.ArrayList;

public class BingoBoard {
    private int[][] board;
    private boolean wonAlready;
    public BingoBoard(ArrayList<String[]>input) {
        this.board = new int[5][5];
        for(int i = 0; i < input.size(); i++) {
            for(int j = 0; j < input.get(i).length; j++) {
                
                board[i][j] = Integer.parseInt(input.get(i)[j]);
            }
        }
        wonAlready = false;
    }

    public boolean hasWon(int number) {
        for(int i = 0; i < board.length;i++) 
            for(int j = 0; j < board[i].length;j++)
                if(number==board[i][j]) {
                    board[i][j] = 100;
                    
                    return checkColumn() || checkRow();
                }
        return false;                              
    }
    public boolean hasWonAlready() {
        return wonAlready;
    }

    public void setHasWonAlready() {
        wonAlready = true;
    }

    private boolean checkRow() {
        boolean won = true;
        for(int i = 0; i < board.length;i++) {
            won = true;
            for(int j = 0; j < board[i].length;j++) {
                if(board[i][j]!=100)
                     won = false;
            }
            if(won)
                return won;
        }
        return won;
    }

    private boolean checkColumn() {
        boolean won = true;
        for(int i = 0; i < board.length;i++) {
            won = true;
            for(int j = 0; j < board[i].length;j++) {
                if(board[j][i]!=100)
                     won = false;
            }
            if(won)
                return won;
        }
        return won;
    }

    public int getSum(int number) {
        int sum = 0;
        for(int i = 0; i < board.length; i++) 
            for(int j = 0; j < board[i].length;j++)
                if(board[i][j]!=100)
                    sum+=board[i][j];
        return sum*number;   
        
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }
}
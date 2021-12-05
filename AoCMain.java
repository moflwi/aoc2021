import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class AoCMain {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        AoCLibary aoCLibary = new AoCLibary();
        try(BufferedReader br = new BufferedReader(new FileReader("resources\\day4input.txt"))) {
           
            String inputNumbers= br.readLine();
            //(System.out.println(inputNumbers);
            br.readLine();
            String line = br.readLine();
            ArrayList<String[]> list = new ArrayList<>();
            ArrayList<BingoBoard> bingoBoards = new ArrayList<>();
            int counter = 0;
            while (line != null) {
                if(counter == 5) {
                    counter = -1;                   
                    bingoBoards.add(new BingoBoard(list));
                    list.clear();                 
                } else {
                    list.add(line.trim().split(" +"));                   
                }               
                line = br.readLine();
                counter++;
                if(line==null && counter==5)
                    bingoBoards.add(new BingoBoard(list));
            }
            //System.out.println(inputNumbers);
            String[]numbers = inputNumbers.split(",");
            for(int i = 0; i < numbers.length;i++){
                for(BingoBoard bingoBoard : bingoBoards) {
                    if(bingoBoard.hasWon(Integer.parseInt(numbers[i])) && !bingoBoard.hasWonAlready()){
                        System.out.println(bingoBoard.getSum(Integer.parseInt(numbers[i])));
                        //System.exit(0);
                        bingoBoard.setHasWonAlready();
                    }
                }
            }
                



            //for(BingoBoard bingoBoard : bingoBoards)
            //  bingoBoard.printBoard();
            
        }
    }
    
}

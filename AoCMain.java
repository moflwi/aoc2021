import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AoCMain {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        AoCLibary aoCLibary = new AoCLibary();
        try(BufferedReader br = new BufferedReader(new FileReader("resources\\day2input1.txt"))) {
           
            String line = br.readLine();
            ArrayList<String[]>list = new ArrayList<>();
            while (line != null) {
                list.add(line.split(" "));
                line = br.readLine();
            }
            System.out.println(aoCLibary.getFinalPosition2(list));
        }
    }
    
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AoCMain {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        AoCLibary aoCLibary = new AoCLibary();
        try(BufferedReader br = new BufferedReader(new FileReader("resources\\day1input2.txt"))) {
            ArrayList<Integer>integers = new ArrayList<>();
            String line = br.readLine();
        
            while (line != null) {
                integers.add(Integer.parseInt(line));
                line = br.readLine();
            }
            System.out.println(aoCLibary.getIncreaseLevels(integers));
            System.out.println(aoCLibary.getIncreaseLevelsOf3(integers));
        }
    }
    
}

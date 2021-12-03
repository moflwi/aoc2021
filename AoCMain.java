import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AoCMain {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        AoCLibary aoCLibary = new AoCLibary();
        try(BufferedReader br = new BufferedReader(new FileReader("resources\\day3input.txt"))) {
           
            String line = br.readLine();
            ArrayList<char[]>list = new ArrayList<>();
            ArrayList<char[]>list2 = new ArrayList<>();
            while (line != null) {
                list.add(line.toCharArray());
                list2.add(line.toCharArray());
                line = br.readLine();
            }
            System.out.println(aoCLibary.getCO2orOxygen(list,list2));
        }
    }
    
}

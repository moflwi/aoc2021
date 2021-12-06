import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AoCSix {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("resources\\day6input.txt"))) {             
            String line = br.readLine();
            long[]count = new long[9]; 
            while (line != null) {
                String[] s = line.split(",");
                for(String str : s) 
                    count[Integer.parseInt(str)]++;                    
                line = br.readLine();
            }
            long fish = 0;
            for(int i = 0; i < 256; i++) {
                if(count[0]>0)
                    fish = count[0];
                for(int j = 1; j < count.length; j++) {
                    count[j-1] = count[j];
                    count[j] = 0;
                }
                count[8]+=fish;
                count[6]+=fish;
                fish = 0;
            }
            System.out.println(Arrays.stream(count).sum());

        }

    }




    
}

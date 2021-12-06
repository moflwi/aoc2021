import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AoCSix {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("resources\\day6input.txt"))) {         
           
    
            String line = br.readLine();
            ArrayList<LanternFish> list = new ArrayList<>();
            
    
            while (line != null) {
                String[] s = line.split(",");
                for(String str : s) 
                    list.add(new LanternFish(Integer.parseInt(str)));                     
                line = br.readLine();
            }
            System.out.println(list.size());
            for(int i = 31; i >= 0; i--) {
                ArrayList<LanternFish> tempList = new ArrayList<>();
                for(LanternFish lf : list) {
                    LanternFish lanternFish = lf.decrement();
                    if(lanternFish!=null)
                        tempList.add(lanternFish);
                }
                list.addAll(tempList);
                tempList.clear();

            }
            System.out.println(list.size());


        }

    }




    
}

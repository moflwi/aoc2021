import java.util.ArrayList;

public class AoCLibary {

    //Libary class
    //day1 part1
    public int getIncreaseLevels(ArrayList<Integer> inputList) {
        int count = 0;
        int prev = inputList.get(0);
        for(int i : inputList){
            if(i > prev) {
                count++;            
            }
            prev = i;
        }
        return count;
    }

    //day1 part2
    public int getIncreaseLevelsOf3(ArrayList<Integer> inputList) {
        int count = -1;
        int prev = 0;
        for(int i = 0; i<inputList.size(); i++) {
            int sum = 0;
            for(int j = i; j < inputList.size() && j < i+3; j++) {
                sum += inputList.get(j);               
            }
            if(prev<sum) {
                count++;
            }
            prev = sum;
        }
        return count;
    }
}
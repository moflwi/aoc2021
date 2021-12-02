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

    //day2 part1
    public int getFinalPosition(ArrayList<String[]>list) {
        int depth = 0;
        int pos = 0;
        for(String[] s : list) 
            if(s[0].equalsIgnoreCase("forward"))
                pos+= Integer.parseInt(s[1]);
            else if(s[0].equalsIgnoreCase("down"))
                depth+= Integer.parseInt(s[1]);
            else
                depth-= Integer.parseInt(s[1]);
        return depth*pos;
    }

    //day2 part2

    public int getFinalPosition2(ArrayList<String[]>list) {
        int aim = 0;
        int depth = 0;
        int pos = 0;
        for(String[] s : list) 
            if(s[0].equalsIgnoreCase("forward")) {
                pos+= Integer.parseInt(s[1]);
                depth = depth + (aim * Integer.parseInt(s[1]));
            }else if(s[0].equalsIgnoreCase("down")) {
                aim+= Integer.parseInt(s[1]);
            }else {
                aim-= Integer.parseInt(s[1]);
            }
        return depth*pos;
    }

}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;



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

    //day3 part1
    public int gammaEpsilon(ArrayList<char[]>list) {
        int[]rate = new int[list.get(0).length];
        for(int i = 0; i < list.get(0).length;i++) {
            int zero = 0;
            int one = 0;
            for(int j = 0; j < list.size();j++) 
                if(list.get(j)[i]=='0')
                    zero++;
                else
                    one++;           
            if(zero>one)
                rate[i]= 0;
            else
                rate[i]= 1;
        }
        String gamma = Arrays.toString(rate).replaceAll("\\[|\\]|,|\\s", "");
        for(int i = 0; i < rate.length; i++)
            if(rate[i]==0)
                rate[i]=1;
            else
                rate[i]=0;
        return Integer.parseInt(gamma, 2)*Integer.parseInt(Arrays.toString(rate).replaceAll("\\[|\\]|,|\\s", ""), 2);
    }

    //day3 part2
    public int getCO2orOxygen(ArrayList<char[]>list, ArrayList<char[]>list2) {
        return Integer.parseInt(Arrays.toString(getOxygen(list)).replaceAll("\\[|\\]|,|\\s", ""), 2)*
           Integer.parseInt(Arrays.toString(getCO2(list2)).replaceAll("\\[|\\]|,|\\s", ""),2);
    }
    //kinda duplicate lol
    private int[] getCO2(ArrayList<char[]>list) {   
        int i = 0;
        while(list.size()>1) {
            int determiner = getDeterminerCO2(list, i);
            for(Iterator<char[]>iter = list.iterator(); iter.hasNext();) {
                char[]row = iter.next();
                if(row[i]!=determiner && list.size()>1)
                    iter.remove();
            }
            i++;
        }
        return asIntArray(list.get(0));
    }

    private int[] getOxygen(ArrayList<char[]>list) {    
        int i = 0;
        while(list.size()>1) {
            int determiner = getDeterminerOxygen(list, i);
            for(Iterator<char[]>iter = list.iterator(); iter.hasNext();) {
                char[]row = iter.next();              
                if(row[i]!=determiner && list.size()>1) 
                    iter.remove();                            
            }
            i++;           
        }
        return asIntArray(list.get(0));
    }

    private int getDeterminerCO2(ArrayList<char[]>list, int index) { 
        int zero = 0;
        int one = 0;
        int determiner;
        for(int i = 0; i < list.size();i++) 
            if(list.get(i)[index]=='0')
                zero++;
            else
                one++;
        if(zero<=one)
            determiner=48;
        else
            determiner=49;
        return determiner;
    }

    private int getDeterminerOxygen(ArrayList<char[]>list, int index) {
        int zero = 0;
        int one = 0;
        int determiner;
        for(int i = 0; i < list.size();i++) 
            if(list.get(i)[index]=='0')
                zero++;
            else
                one++;
        if(zero<=one)
            determiner=49;
        else
            determiner=48;
        return determiner;
    }

    private int[] asIntArray(char[] charArray) { 
        int[]results = new int[charArray.length];
        for(int i = 0; i < charArray.length;i++)
            if(charArray[i]=='0')
                results[i]=0;
            else
                results[i]=1;     
        return results; 
    } 

    //day4 part1
    
    //day4 part2

    //day5 part1 and 2
    public int getVentCount(ArrayList<String[]>list) {
        ArrayList<Vents> vents = new ArrayList<>();
        for(String[]s : list) {
            String[] point1 = s[0].split(",");
            String[] point2 = s[1].split(",");
            vents.add(new Vents(Integer.parseInt(point1[0]),Integer.parseInt(point1[1]), Integer.parseInt(point2[0]), Integer.parseInt(point2[1])));        
        }
      
        
        int count = 0;
        byte[][] positions = new byte[1000][1000];
        for(Vents vent : vents) {
            ArrayList<AoCLibary.Vents.Point> points = vent.comparePoints();
            ArrayList<AoCLibary.Vents.Point> diaPoints = vent.compareAlsoDiagonal();
            if(!points.isEmpty())
                for(AoCLibary.Vents.Point point : points) {
                    positions[point.getY()][point.getX()]++;                   
                    if(positions[point.getY()][point.getX()] > 1 && positions[point.getY()][point.getX()] < 3)
                        count++;
                }
            if(!diaPoints.isEmpty())
                for(AoCLibary.Vents.Point point : diaPoints) {
                    positions[point.getY()][point.getX()]++;
                    if(positions[point.getY()][point.getX()] > 1 && positions[point.getY()][point.getX()] < 3)
                        count++;
                }                
        }
        return count;
    }

    



    public class Vents {
        private Point p1;
        private Point p2;
        public Vents(int x, int y, int x1, int y1) {
            p1 = new Point(x,y);
            p2 = new Point(x1, y1);
        }

        public Point getP1() {
            return this.p1;
        }

        public Point getP2() {
            return this.p2;
        }

        public ArrayList<Point> compareAlsoDiagonal() { 
            ArrayList<Point> points = new ArrayList<>();         
                if(p1.x < p2.x && p1.y < p2.y) 
                    for(int i = p1.x, j = p1.y; i <= p2.x && j <= p2.y; i++, j++) 
                        points.add(new Point(i,j));
                else if(p1.x < p2.x && p1.y > p2.y)
                    for(int i = p1.x, j = p1.y; i <= p2.x && j >= p2.y; i++, j--)
                        points.add(new Point(i,j));
                else if(p1.x > p2.x && p1.y < p2.y)
                    for(int i = p1.x, j = p1.y; i >= p2.x && j <= p2.y; i--, j++)
                        points.add(new Point(i,j));
                else if(p1.x > p2.x && p1.y > p2.y)
                    for(int i = p1.x, j = p1.y; i >= p2.x && j >= p2.y; i--, j--)
                        points.add(new Point(i,j));      
            return points;
        }
        
        public ArrayList<Point> comparePoints() {
            ArrayList<Point> points = new ArrayList<>();
            if(p1.x==p2.x || p1.y == p2.y) 
                if(p2.x > p1.x || p2.y > p1.y) 
                    if(p1.x==p2.x)
                        for(int i = p1.y; i <= p2.y; i++)
                            points.add(new Point(p1.x, i));
                    else
                        for(int i = p1.x; i <= p2.x; i++)
                            points.add(new Point(i, p1.y));
                else 
                    if(p1.x==p2.x) 
                        for(int i = p1.y; i >= p2.y; i--) 
                            points.add(new Point(p1.x, i));
                    else
                        for(int i = p1.x; i >= p2.x; i--) 
                            points.add(new Point(i, p1.y));                        
            return points;
        }

        private class Point{
            private int x;
            private int y;
            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            private int getX() {
                return this.x;
            }
            private int getY() {
                return this.y;
            }
        }
    }


}
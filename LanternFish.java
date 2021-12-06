public class LanternFish {
    private int counter;

    public LanternFish(int counter) {
        this.counter = counter;
    }

    public LanternFish decrement() {
        counter--;
        if(counter < 0) {
            counter = 6;
            return new LanternFish(8);             
        }
        else return null;
    }

    

}
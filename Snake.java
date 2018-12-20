import java.util.*;
public class Snake{
    //20 by 20 board
    ArrayList<int[]> s;
    int[] foodCords;
    int direction;
    public Snake(){
        reset();
    }
    public void reset(){
        s = new ArrayList<int[]>();
        int[] start = {10,10};
        s.add(start);
        foodCords = new int[2];
        randFoodCord();
        direction = Math.random()
    }
    public void randFoodCord(){
        foodCords[0] = (int)(Math.random()*20+1);
        foodCords[1] = (int)(Math.random()*20+1);
    }
    public void simulate(NeuralNetwork NN){
        boolean contin = true;
        while(contin){
            
        }
    }
}
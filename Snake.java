import java.util.*;
public class Snake{
    //20 by 20 board
    ArrayList<int[]> s;
    int[] foodCords;
    double score;
    public Snake(){
        reset();
    }
    public void reset(){
        s = new ArrayList<int[]>();
        int[] start = {10,10};
        s.add(start);
        int[] end = {9,10};
        s.add(end);
        foodCords = new int[2];
        randFoodCord();
        score = 0;
    }
    public void randFoodCord(){
        foodCords[0] = (int)(Math.random()*20+1);
        foodCords[1] = (int)(Math.random()*20+1);
    }
    public boolean tailContains(int x,int y){
        for(int i = 0; i < s.size(); i++){
            if(s.get(i)[0] == x && s.get(i)[1] == y){
                return true;
            }
        }
        return false;
    }
    public void checkEatenFood(){
        if(s.get(0)[0] == foodCords[0] && s.get(0)[1] == foodCords[1]){
            score += 2;
            randFoodCord();
        }
    }
    public double[] getInputs(){
        double[] ins = new double[8];
        if(s.get(0)[1]-1 <= 0 || tailContains(s.get(0)[0],s.get(0)[1]-1)){
            ins[0] = 1;
        }
        else{
            ins[0] = 0;
        }
        if(s.get(0)[1]+1 >= 20 || tailContains(s.get(0)[0]+1,s.get(0)[1])){
            ins[1] = 1;
        }
        else{
            ins[1] = 0;
        }
        if(s.get(0)[1]+1 <= 0 || tailContains(s.get(0)[0],s.get(0)[1]+1)){
            ins[2] = 1;
        }
        else{
            ins[2] = 0;
        }
        if(s.get(0)[1]-1 >= 20 || tailContains(s.get(0)[0]-1,s.get(0)[1])){
            ins[3] = 1;
        }
        else{
            ins[3] = 0;
        }
        ins[4] = s.get(0)[0]/20;
        ins[5] = s.get(0)[1]/20;
        ins[6] = foodCords[0]/20;
        ins[7] = foodCords[1]/20;
        return ins;
    }
    public int getChoice(double[] vals){
        int largest = 0;
        for(int i = 0; i < vals.length;i++){
            if(vals[i] > vals[largest]){
                largest = i;
            }
        }
        return largest;
    }
    public void move(int x,int y){
        for(int i = 1;i < s.size();i++){
            s.set(i,s.get(i-1));
        }
        s.get(0)[0] = x;
        s.get(0)[1] = y;
    }
    public boolean checkCollition(){
        if(tailContains(s.get(0)[0],s.get(0)[1])){
            return true;
        }
        if(s.get(0)[0] <= 0 || s.get(0)[0] >= 20 || s.get(0)[1] <= 0 || s.get(0)[1] >= 20){
            return true;
        }
        return false;
    }
    public void simulate(NeuralNetwork NN, boolean isVisible){
        boolean contin = true;
        while(contin){
            int choice = getChoice(NN.forwardPropagate(getInputs()));
            if(choice == 0){
                if(s.get(1)[1] != s.get(0)[1]-1){
                    move(s.get(0)[0],s.get(0)[1]-1);
                }
                else{
                    move(s.get(0)[0],s.get(0)[1]+1);
                }
            }
            else if(choice == 1){
                if(s.get(1)[0] != s.get(0)[0]+1){
                    move(s.get(0)[0]+1,s.get(0)[1]);
                }
                else{
                    move(s.get(0)[0]-1,s.get(0)[1]);
                }
            }
            else if(choice == 2){
                if(s.get(1)[1] != s.get(0)[1]+1){
                    move(s.get(0)[0],s.get(0)[1]+1);
                }
                else{
                    move(s.get(0)[0],s.get(0)[1]-1);
                }
            }
            else{
                if(s.get(1)[0] != s.get(0)[0]-1){
                    move(s.get(0)[0]-1,s.get(0)[1]);
                }
                else{
                    move(s.get(0)[0]+1,s.get(0)[1]);
                }   
            }
            if(checkCollition()){
                break;
            }
            checkEatenFood();
            if(isVisible){
                try{
                        Thread.sleep(25);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        NN.setFitness((int)(score+0.5));
    }
}
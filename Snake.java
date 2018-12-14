import java.util.*;
public class Snake{
    ArrayList<Box> tail;
    int headX = 5;
    int headY = 5;
    int tailX = 5;
    int tailY = 5;
    boolean growing = false;
    public Snake(){
        tail = new ArrayList<Box>();
        tail.add(new Box(1,1));
    }
    //0 == up
    //1 == right
    //2 == down
    //3 == left
    public void move(int d){
        if(d == 0){
            turnLeft();
        }
        else if(d == 1){
            goStraight();
        }
        else{
            turnRight();
        }
        tail.get(0).setLocation(headX,headY);
        if(growing){
            growing = false;
            tail.add(new Box(tailX,tailY));
            tail.get(tail.size() - 2).connect(tail.get(tail.size() - 1));
        }
        tailX = tail.get(tail.size() - 1).getX();
        tailX = tail.get(tail.size() - 1).getY();
    }
    public void turnRight(){
        
    }
    public void turnLeft(){
        
    }
    public void goStraight(){
        
    }
    public void grow(){
        growing = true;
    }
}